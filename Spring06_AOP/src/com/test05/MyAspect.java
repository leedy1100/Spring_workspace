package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class MyAspect {

	public void myClass() {}
	
	@Before("")
	public void befor() {
		System.out.println("출석 카드 찍는다.");
	}
	
	@After("")
	public void after() {
		System.out.println("집에 간다.");
	}
}
