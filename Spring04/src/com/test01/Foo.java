package com.test01;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Foo {

	Bar bar;

	public Foo() {
		System.out.println("Foo() 객체 생성");
	}

	public Foo(Date date) {
		System.out.println("Foo(date) 객체 생성 : " + date);
	}

	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar() 호출");
	}

	public void setDate(Date date) {
		System.out.println("setDate() 호출  : " + date);
	}

	public void setNum(int num) {
		System.out.println("setNum() 호출 : " + num);
	}

	public void setStudent(String[] student) {
		System.out.println("setStudent() 호출");
		for (String person : student) {
			System.out.println(person);
		}
	}
	
	public void setInfo(List<String> item) {
		System.out.println("setInfo() 호출");
		for(String res : item) {
			System.out.println(res);
		}
	}
	
	public void setSeason(Map<String, String> season) {
		System.out.println("setSeason() 호출");
		Set<String> keys = season.keySet();
		for(String key : keys) {
			System.out.println(key + "의 계절 : " + season.get(key));
		}
	}
}
