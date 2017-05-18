package com.net.lnk.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("MyAfterReturningAdvice, result = " + result);
	}

}
