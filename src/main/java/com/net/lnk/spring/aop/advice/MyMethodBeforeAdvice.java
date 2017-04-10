package com.net.lnk.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("MyMethodBeforeAdvice, before invoke " + method.getName());
	}

}
