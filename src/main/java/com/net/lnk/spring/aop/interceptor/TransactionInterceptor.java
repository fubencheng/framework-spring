package com.net.lnk.spring.aop.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
public class TransactionInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = methodInvocation.getMethod().getName();
		Method method = methodInvocation.getThis().getClass().getMethod(methodName,
				methodInvocation.getMethod().getParameterTypes());
		// 方法上的注解
		Transactional tx = method.getAnnotation(Transactional.class);
		if (tx == null) {
			// 类上的注解
			tx = methodInvocation.getClass().getAnnotation(Transactional.class);
		}

		if (tx != null) {
			if (tx.readOnly()) {
				System.out.println("Begin readOnly transaction...");
			} else {
				System.out.println("Begin transaction...");
			}
		}

		Object obj = methodInvocation.proceed();
		return obj;
	}

}
