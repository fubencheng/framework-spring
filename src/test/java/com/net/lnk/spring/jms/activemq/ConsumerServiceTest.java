package com.net.lnk.spring.jms.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/jms/applicationContext-activemq-consumer.xml" })
public class ConsumerServiceTest {

	@Autowired
	private ConsumerService consumerService;

	@Test
	public void testGetActiveMQObjectMessage() {
		consumerService.getActiveMQObjectMessage();
	}

	@Test
	public void testGetActiveMQTopicObjectMessage() {
		consumerService.getActiveMQTopicObjectMessage();
	}

}
