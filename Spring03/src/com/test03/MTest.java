package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		Emp dev = (Developer)factory.getBean("you");
		Emp eng = factory.getBean("kang",Engineer.class);
		
		System.out.println(dev);
		System.out.println(eng);
	}
}
