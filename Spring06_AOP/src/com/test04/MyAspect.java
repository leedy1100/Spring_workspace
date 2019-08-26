package com.test04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execution(public * *(..))")
	public void before() {
		System.out.println("출석 카드 찍는다.");
	}
	
	@After("execution(public * *(..))")
	public void after() {
		System.out.println("집에 간다.");
	}
}
