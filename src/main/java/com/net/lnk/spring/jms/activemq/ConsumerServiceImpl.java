package com.net.lnk.spring.jms.activemq;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void getActiveMQObjectMessage() {
		try {
			ObjectMessage msg = (ObjectMessage) jmsTemplate.receive("user.alert.queue");
			UserBean user = (UserBean) msg.getObject();

			System.out.println(user.toString());

		} catch (JMSException jmsException) {
			throw JmsUtils.convertJmsAccessException(jmsException);
		}
	}

}
