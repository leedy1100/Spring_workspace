package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO : 005.biz (Service)
@Service
public class HelloBiz {

	@Autowired
	private HelloDao dao;

	public String getHello() {
		
		// TODO : 008. biz에서 return "Hello, mvc"
		return "Hello, " + dao.getHello();
	}
}
