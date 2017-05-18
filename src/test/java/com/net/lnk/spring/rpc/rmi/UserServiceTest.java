package com.net.lnk.spring.rpc.rmi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.net.lnk.spring.model.UserBean;
import com.net.lnk.spring.rpc.UserService;

/**
 * @author Ben
 * @memo 2017年3月30日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/rpc/applicationContext-rpc-consumer.xml" })
public class UserServiceTest {

	@Autowired
	@Qualifier("rmiUserService")
	private UserService userService;

	@Test
	public void testAddUser() {
		UserBean user = new UserBean();
		user.setUsername("WuWuWu");
		user.setFullname("WuWuWu.Doss");
		user.setPassword("WuWu123");
		userService.addUser(user);
	}

}
