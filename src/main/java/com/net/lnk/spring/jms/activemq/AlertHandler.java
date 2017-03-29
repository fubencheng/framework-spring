package com.net.lnk.spring.jms.activemq;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月29日
 */
public class AlertHandler {

	public void handleAlert(UserBean user) {
		System.out.println("AlertHandler : " + user.toString());
	}

}
