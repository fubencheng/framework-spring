package com.net.lnk.spring.mvc.service;

import com.net.lnk.spring.model.UserBean;

public interface UserService {

	void addUser(UserBean user);

	UserBean findUser(String fullname);

}
