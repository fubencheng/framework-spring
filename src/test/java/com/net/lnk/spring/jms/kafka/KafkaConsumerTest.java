package com.net.lnk.spring.jms.kafka;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ben
 * @memo 2017年5月18日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/jms/applicationContext-kafka-consumer.xml" })
public class KafkaConsumerTest {

	@Autowired
	private KafkaConsumer<String, Object> kafkaConsumer;

	@Test
	public void testKafkaConsumer() {
		kafkaConsumer.subscribe(Arrays.asList("topic-1", "test"));

		ConsumerRecords<String, Object> records = kafkaConsumer.poll(100);
		for (ConsumerRecord<String, Object> record : records) {
			System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
		}

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
