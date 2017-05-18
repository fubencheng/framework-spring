package com.net.lnk.spring.jdbc;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.net.lnk.spring.jdbc.service.IdCardService;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
public class QueryIdCardTask implements Runnable {

	private IdCardService idCardService;

	private List<Long> ids;

	private BlockingQueue<IdCardEntity> blockingQueue;

	public QueryIdCardTask(IdCardService idCardService, List<Long> ids, BlockingQueue<IdCardEntity> blockingQueue) {
		this.idCardService = idCardService;
		this.ids = ids;
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		List<IdCardEntity> idCards = idCardService.getIdCards(ids);

		for (IdCardEntity idCard : idCards) {
			System.out.println(Thread.currentThread().getName() + " offer object, id = " + idCard.getId());
			blockingQueue.offer(idCard);
		}
	}

}
