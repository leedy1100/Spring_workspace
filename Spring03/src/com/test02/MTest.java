package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		BirthDto dto = factory.getBean("dto",BirthDto.class);
		System.out.println(dto.getName());
		System.out.println(dto.getBirth());
		
		dto = factory.getBean("dto2",BirthDto.class);
		System.out.println(dto.getName());
		System.out.println(dto.getBirth());
		
	}
}
