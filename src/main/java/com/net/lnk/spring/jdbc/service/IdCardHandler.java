package com.net.lnk.spring.jdbc.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.net.lnk.spring.jdbc.IdCardEntity;
import com.net.lnk.spring.jdbc.QueryIdCardTask;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
@Component("idCardHandler")
public class IdCardHandler implements AsynHandler {

	@Autowired
	private IdCardService idCardService;

	private final ExecutorService pool = Executors.newFixedThreadPool(20);

	protected final ArrayBlockingQueue<IdCardEntity> blockingQueue = new ArrayBlockingQueue<IdCardEntity>(100);

	public void asynHandleIdCardQuery(List<Long> ids) {
		FileOutputStream output = null;
		try {
			output = new FileOutputStream("file/ids.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (long id : ids) {
			pool.execute(new QueryIdCardTask(idCardService, Arrays.asList(id), blockingQueue));
		}

		try {
			while (true) {
				IdCardEntity idCard = null;
				idCard = blockingQueue.poll(5, TimeUnit.SECONDS);
				if (idCard != null) {
					// 多线程打印出来
					// pool.execute(new IdCardHandleTask(idCard));

					// 写文件
					String idStr = StringUtils.join(
							Arrays.asList(idCard.getName(), idCard.getIdNo(), idCard.getMemberNo(), idCard.getIdAddr()),
							"|");
					for (int i = 0; i < 10000; i++) {
						IOUtils.writeLines(Arrays.asList(idStr), "\n", output, "UTF-8");
					}
				} else {
					// 5秒后还是没有等到数据，退出循环
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(output);
		}
	}

}
