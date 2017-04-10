package com.net.lnk.spring.aop;

import org.springframework.transaction.annotation.Transactional;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public class UserServiceImpl implements UserService {

	@Transactional
	public int saveUser() {
		System.out.println("Save user...");

		return 1;
	}

	public UserBean getUser(long id) {
		UserBean user = new UserBean();
		user.setFullname("HaHaHa.Doss");
		user.setUsername("HaHaHa");
		user.setPassword("hahaha123");
		return user;
	}

}
