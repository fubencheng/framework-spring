package com.net.lnk.spring.jms.activemq;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
public interface AlertService {

	void sendUserAlert(UserBean user);

	void sendUserAlertByTopic(UserBean user);

	UserBean findUser(String fullname);

	void saveUser(UserBean user);

}
