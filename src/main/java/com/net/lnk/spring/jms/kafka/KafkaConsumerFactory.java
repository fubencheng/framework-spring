package com.net.lnk.spring.jms.kafka;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Ben
 * @memo 2017年5月18日
 */
public class KafkaConsumerFactory implements FactoryBean<KafkaConsumer<String, Object>> {

	public KafkaConsumer<String, Object> getObject() throws Exception {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "127.0.0.1:9092");
		props.setProperty("group.id", "kafkaConsumerGroup");
		props.setProperty("session.timeout.ms", "10000");
		props.setProperty("heartbeat.interval.ms", "3000");
		props.setProperty("metadata.max.age.ms", "300000");
		props.setProperty("enable.auto.commit", "true");
		props.setProperty("auto.commit.interval.ms", "5000");
		props.setProperty("client.id", "kafkaConsumerClient");
		props.setProperty("max.partition.fetch.bytes", "1048576");
		props.setProperty("send.buffer.bytes", "131072");
		props.setProperty("receive.buffer.bytes", "65536");
		props.setProperty("fetch.max.bytes", "52428800");
		props.setProperty("fetch.max.wait.ms", "500");
		props.setProperty("reconnect.backoff.ms", "50");
		props.setProperty("retry.backoff.ms", "100");
		props.setProperty("request.timeout.ms", "305000");
		props.setProperty("connections.max.idle.ms", "540000");
		props.setProperty("max.poll.records", "500");
		props.setProperty("max.poll.interval.ms", "300000");
		props.setProperty("key.deserializer", StringDeserializer.class.getName());
		props.setProperty("value.deserializer", StringDeserializer.class.getName());
		KafkaConsumer<String, Object> consumer = new KafkaConsumer<String, Object>(props);

		return consumer;
	}

	@SuppressWarnings("rawtypes")
	public Class<KafkaConsumer> getObjectType() {
		return KafkaConsumer.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
