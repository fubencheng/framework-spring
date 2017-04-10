package com.net.lnk.spring.aop;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public interface UserService {

	int saveUser();

	UserBean getUser(long id);

}
