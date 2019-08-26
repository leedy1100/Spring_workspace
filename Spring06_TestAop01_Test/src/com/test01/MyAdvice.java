package com.test01;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	public MyAdvice() {}
	
	@Before("execution(public * com.test01.Person.sayName(..))")
	public void beforeSaying() {
		System.out.println("당신의 이름은 무엇입니까?");
	}
	@After("execution(public * com.test01.Person.sayJob(..))")
	public void afterSaying(){
		System.out.println("이름이 멋지시네요.");
	}
	@AfterReturning("execution(public * com.test01.Person.sayJob(..))")
	public void afterReturnSaying() {
		System.out.println("직업은 무엇입니까?");
	}
}
