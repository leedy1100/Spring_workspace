package com.hello.mvc2.model;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

	public String getHello() {
		return "hello";
	}
	
}
