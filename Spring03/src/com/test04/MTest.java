package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		Developer you = factory.getBean("you",Developer.class);
		Engineer kang = factory.getBean("kang",Engineer.class);
		
		System.out.println(you);
		System.out.println(kang);
	}
}
