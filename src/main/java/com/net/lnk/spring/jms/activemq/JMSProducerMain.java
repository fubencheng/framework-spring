package com.net.lnk.spring.jms.activemq;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @tag 启动服务端监听器
 * @author Ben
 * @memo 2017年3月29日
 */
public class JMSProducerMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/jms/applicationContext-activemq-producer.xml" });
		ctx.registerShutdownHook();
		ctx.start();

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
