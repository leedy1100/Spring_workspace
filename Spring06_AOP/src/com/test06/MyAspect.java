package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
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
