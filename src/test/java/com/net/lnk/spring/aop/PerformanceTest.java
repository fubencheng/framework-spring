package com.net.lnk.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/aop/applicationContext-aop.xml" })
public class PerformanceTest {

	@Autowired
	private Performer instrumentalist;

	@Test
	public void testPerform() {
		try {
			instrumentalist.perform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}
	}

}
