package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		UserService service = factory.getBean("service", UserServiceImpl.class);
		
		UserDto dto = factory.getBean("dto",UserDto.class);
		System.out.println(dto.getName());
		System.out.println(dto.getMyDate());
		
		service.addUser(dto);
		
	}
}
