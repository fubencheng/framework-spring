package com.net.lnk.spring.rpc;

import org.springframework.stereotype.Service;

import com.net.lnk.spring.model.UserBean;

@Service("userService")
public class UserServiceImpl implements UserService {

	public void addUser(UserBean user) {
		System.out.println("Add user, user = " + user.toString());
	}

}
