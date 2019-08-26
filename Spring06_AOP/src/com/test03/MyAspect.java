package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void before(JoinPoint join) {
		System.out.println("출석카드 찍는다.");
	}
	
	public void after(JoinPoint join) {
		System.out.println("집에간다");
	}
	
	public void afterThrowing(JoinPoint join) {
		System.out.println("쉬는 날이다");
	}
}
