package com.net.lnk.spring.jms.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author Ben
 * @memo 2017年5月17日
 */
public class KafkaProducerFactory extends AbstractFactoryBean<KafkaProducer<String, Object>> {

	@SuppressWarnings("rawtypes")
	@Override
	public Class<KafkaProducer> getObjectType() {
		return KafkaProducer.class;
	}

	@Override
	protected KafkaProducer<String, Object> createInstance() throws Exception {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "127.0.0.1:9092");
		props.setProperty("acks", "1");
		props.setProperty("buffer.memory", "33554432");
		props.setProperty("compression.type", "none");
		props.setProperty("retries", "0");
		props.setProperty("batch.size", "16384");
		props.setProperty("client.id", "kafkaProducer");
		props.setProperty("linger.ms", "0");
		props.setProperty("max.request.size", "1048576");
		props.setProperty("receive.buffer.bytes", "32768");
		props.setProperty("send.buffer.bytes", "131072");
		props.setProperty("timeout.ms", "30000");
		props.setProperty("block.on.buffer.full", "true");
		props.setProperty("metadata.fetch.timeout.ms", "60000");
		props.setProperty("metadata.max.age.ms", "300000");
		props.setProperty("reconnect.backoff.ms", "10");
		props.setProperty("retry.backoff.ms", "100");
		props.setProperty("key.serializer", StringSerializer.class.getName());
		props.setProperty("value.serializer", StringSerializer.class.getName());
		KafkaProducer<String, Object> producer = new KafkaProducer<String, Object>(props);

		return producer;
	}

}
