package com.net.lnk.spring.jms.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.net.lnk.spring.model.UserBean;

/**
 * @author Ben
 * @memo 2017年3月28日
 */
@Service("alertService")
public class AlertServiceImpl implements AlertService {

	@Autowired
	private KafkaProducer<String, Object> kafkaProducer;

	public void sendUserAlert(String topic, UserBean user) {
		ProducerRecord<String, Object> record = new ProducerRecord<String, Object>(topic, "key-1",
				JSON.toJSONString(user));
		kafkaProducer.send(record);
	}

	public void sendUserAlertByTopic(UserBean user) {
		// TODO Auto-generated method stub

	}

	public UserBean findUser(String fullname) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(UserBean user) {
		// TODO Auto-generated method stub

	}

}
