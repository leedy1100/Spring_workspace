package com.edu.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("rect")
public class Rectangle extends Shape {

	public Rectangle() {
	}

	@Autowired
	public Rectangle(String title, int data1, int data2) {
		super(title, data1, data2);
	}

	@Override
	public void viewSize() {
		System.out.println(title + "의 넓이 : " + data1*data2);
	}

}
