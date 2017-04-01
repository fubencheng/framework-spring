package com.net.lnk.spring.mvc.controller;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.net.lnk.spring.model.UserBean;
import com.net.lnk.spring.mvc.service.UserService;

/**
 * @author Ben
 * @memo 2017年3月31日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/mvc/webApplicationContext.xml" })
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@Test
	public void testFindUser() {
		String vievName = userController.findUser("HuHuHu.Doss", new HashMap<String, Object>());

		Assert.assertEquals("user_detail", vievName);
	}

	@Test
	public void testFindUserByMock() {
		UserBean expectedUser = new UserBean();
		expectedUser.setFullname("WuWuWu.Doss");
		expectedUser.setUsername("WuWuWu");
		expectedUser.setPassword("WuWu123");
		UserService userService = Mockito.mock(UserService.class);
		Mockito.when(userService.findUser(Mockito.anyString())).thenReturn(expectedUser);

		UserController userController = new UserController();
		userController.setUserService(userService);
		String viewName = userController.findUser("WuWuWu.Doss", new HashMap<String, Object>());
  
		Assert.assertEquals("user_detail", viewName);
		Mockito.verify(userService).findUser("WuWuWu.Doss");
	}

}
