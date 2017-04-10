package com.net.lnk.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ben
 * @memo 2017年4月7日
 */
@Aspect
@Component("myAspect")
public class MyAspect {

	@Pointcut("execution(* com.net.lnk.spring.aop.UserService.*(..))")
	private void anyMethod() { // 定义切点
	}

	@Before("anyMethod()")
	public void before() {
		System.out.println("My aspect, before advice...");
	}

	@After("anyMethod()")
	public void after() {
		System.out.println("My aspect, after advice...");
	}

	@AfterThrowing("anyMethod()")
	public void afterThrowing() {
		System.out.println("My aspect, after throwing advice...");
	}

	@AfterReturning("anyMethod()")
	public void afterReturning() {
		System.out.println("My aspect, after returning advice...");
	}

	@Around("anyMethod()")
	public Object around(ProceedingJoinPoint jointPoint) {
		try {
			System.out.println("My aspect, around advice, before proceed...");
			Object obj = jointPoint.proceed();
			System.out.println("My aspect, around advice, after proceed...");
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("My aspect, around advice, proceed failed...");
		}

		return null;
	}

}
