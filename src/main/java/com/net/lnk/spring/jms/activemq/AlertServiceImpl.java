package com.net.lnk.spring.jms.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
@Service("alertService")
public class AlertServiceImpl implements AlertService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendUserAlert(final UserBean user) {
		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(user);
			}

		});
	}

}
