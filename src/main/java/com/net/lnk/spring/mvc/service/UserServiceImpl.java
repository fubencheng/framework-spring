package com.net.lnk.spring.mvc.service;

import org.springframework.stereotype.Service;

import com.net.lnk.spring.model.UserBean;

@Service("userService")
public class UserServiceImpl implements UserService {

	public void addUser(UserBean user) {
		System.out.println("Add user, user = " + user.toString());
	}

	public UserBean findUser(String fullname) {
		UserBean user = new UserBean();
		user.setFullname(fullname);
		user.setUsername("HuHuHu");
		user.setPassword("HuHu123");
		return user;
	}

}
