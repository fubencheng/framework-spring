package com.net.lnk.spring.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public class LogInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("LogInterceptor, add log...");
		Object obj = methodInvocation.proceed();
		return obj;
	}

}
