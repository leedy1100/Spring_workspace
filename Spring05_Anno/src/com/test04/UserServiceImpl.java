package com.test04;

// TODO : 002. <bean id="userService" class="com.test04.UserServiceImpl"/>을 annoatation으로
public class UserServiceImpl implements UserService {

	// TODO : 003. <bean id="myUser01" class="com.test04.UserDto"/>를 annotation으로
	private UserDto dto;

	@Override
	public void addUser() {
		System.out.println("추가된 멤버 : " + dto.getName());

	}

	
}
