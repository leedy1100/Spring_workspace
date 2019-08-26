package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");

		System.out.println("여학생 입장");
		Person w = factory.getBean("woman", Person.class);
		w.classWork();
		System.out.println("------------------");
		System.out.println("남학생 입장");
		Person m = factory.getBean("man", Person.class);
		m.classWork();

	}
}
