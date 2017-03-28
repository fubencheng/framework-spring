package com.net.lnk.spring.jms.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/jms/applicationContext-activemq-producer.xml" })
public class AlertServiceTest {

	@Autowired
	private AlertService alertService;

	@Test
	public void testSendUserAlert() {
		UserBean user = new UserBean();
		user.setUsername("Lily");
		user.setFullname("Lily.Doss");
		user.setPassword("DaDa123");
		alertService.sendUserAlert(user);
	}

}
