package com.test04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// TODO : 002. <bean id="userService" class="com.test04.UserServiceImpl"/>을 annoatation으로
@Component("userService")
public class UserServiceImpl implements UserService {

	// TODO : 003. <bean id="myUser01" class="com.test04.UserDto"/>를 annotation으로
	@Autowired
//	@Qualifier("myUser02")
//	@Resource(name = "myUser022")
	private UserDto dto;

	@Override
	public void addUser() {
		System.out.println("추가된 멤버 : " + dto.getName());

	}

}
