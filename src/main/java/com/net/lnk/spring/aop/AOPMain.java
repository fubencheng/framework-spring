package com.net.lnk.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public class AOPMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/aop/applicationContext-aop.xml" });

		Performer instrumentalist = ctx.getBean("instrumentalist", Performer.class);

		try {
			instrumentalist.perform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}

	}

}
