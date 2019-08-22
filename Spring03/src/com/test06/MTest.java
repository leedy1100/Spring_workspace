package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/beans.xml");
		
		Developer dev = factory.getBean("you2",Developer.class);
		Engineer eng = factory.getBean("kang2",Engineer.class);
	
		System.out.println(dev);
		System.out.println(eng);
	
	}
}
