package com.net.lnk.spring.rpc;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ben
 * @memo 2017年3月30日
 */
public class RMIRpcMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/rpc/applicationContext-rpc-provider.xml" });
		ctx.registerShutdownHook();
		ctx.start();

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
