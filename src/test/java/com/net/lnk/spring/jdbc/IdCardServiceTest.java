package com.net.lnk.spring.jdbc;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.net.lnk.spring.jdbc.service.AsynHandler;
import com.net.lnk.spring.jdbc.service.IdCardService;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/jdbc/applicationContext-jdbc.xml" })
public class IdCardServiceTest {

	@Autowired
	private IdCardService idCardService;

	@Autowired
	private AsynHandler idCardHandler;

	@Test
	public void testGetIdCard() {
		IdCardEntity idCard = idCardService.getIdCard(13049);
		System.out.println("name = " + idCard.getName() + ", idNo = " + idCard.getIdNo());
	}

	@Test
	public void testGetIdCards() {
		List<Long> idLong = Arrays.asList(13401L, 13053L);
		List<IdCardEntity> ids = idCardService.getIdCards(idLong);
		System.out.println("id cards size = " + ids.size());
	}

	@Test
	public void testAsynHandleIdCardQuery() {
		List<Long> ids = Arrays.asList(13679L, 13453L, 13585L, 13079L, 13509L, 13589L, 13883L, 13765L, 13769L, 13789L,
				13737L, 13929L, 13675L, 13269L, 13361L, 13473L, 13527L, 13915L, 13925L, 13227L, 13889L, 13417L, 13901L,
				13465L, 13865L, 13809L, 13479L, 13581L, 13577L, 13471L, 13085L, 13743L, 13209L, 13449L, 13217L, 13579L,
				13377L, 13863L, 13565L, 13375L, 13569L, 13793L, 13669L, 13087L, 13759L, 13713L, 13531L, 13483L, 13505L);
		idCardHandler.asynHandleIdCardQuery(ids);

		try {
			Thread.sleep(3 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
