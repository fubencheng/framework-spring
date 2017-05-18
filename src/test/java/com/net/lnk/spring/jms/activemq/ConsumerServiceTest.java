package com.net.lnk.spring.jms.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/jms/applicationContext-activemq-consumer.xml" })
public class ConsumerServiceTest {

	@Autowired
	private ConsumerService consumerService;

	@Autowired
	@Qualifier("alertService")
	private AlertService alertService;

	@Autowired
	@Qualifier("lingoAlertService")
	private AlertService lingoAlertService;

	@Test
	public void testGetActiveMQObjectMessage() {
		consumerService.getActiveMQObjectMessage();
	}

	@Test
	public void testGetActiveMQTopicObjectMessage() {
		consumerService.getActiveMQTopicObjectMessage();
	}

	@Test
	public void testFindUser() {
		UserBean user = alertService.findUser("dududu.Doss");

		System.out.println(user.toString());
	}

	@Test
	public void testSaveUser() {
		UserBean user = new UserBean();
		user.setUsername("BuBuBu");
		user.setFullname("BuBuBu.Doss");
		user.setPassword("BuBuBu123");
		lingoAlertService.saveUser(user);
	}

}
