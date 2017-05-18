package com.net.lnk.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ben
 * @memo 2017年4月10日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/aop/applicationContext-aop.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSaveUser() {
		userService.saveUser();
	}

	@Test
	public void testGetUser() {
		userService.getUser(1L);
	}

}
