package com.test01;


public class Person implements Human {

	String name;
	String job;
	
	@Override
	public String sayName(String name) {
		System.out.println(1);
		return "나의 이름은 " + name + "입니다.";
	}

	@Override
	public String sayJob(String job) {
		System.out.println(2);
		return "나의 직업은 " +job+ "입니다.";
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
}
