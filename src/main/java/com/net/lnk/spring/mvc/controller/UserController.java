package com.net.lnk.spring.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.net.lnk.spring.model.UserBean;
import com.net.lnk.spring.mvc.service.UserService;

/**
 * @author Ben
 * @memo 2017年3月31日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/detail")
	public String findUser(@PathVariable String fullname, Map<String, Object> model) {
		UserBean user = userService.findUser(fullname);

		model.put("user", user);

		return "user_detail";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
