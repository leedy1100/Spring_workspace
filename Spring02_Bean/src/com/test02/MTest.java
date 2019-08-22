package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {

		ApplicationContext beans =new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		Address hong = (Address)beans.getBean("hong");
		Address lee = (Address)beans.getBean("lee");
		Address kim = (Address)beans.getBean("kim");
		
		System.out.println(hong);
		System.out.println(lee);
		System.out.println(kim);
		
		JobAddress jhong = beans.getBean("jhong", JobAddress.class);
		JobAddress jlee = beans.getBean("jlee", JobAddress.class);
		JobAddress jkim = beans.getBean("jkim", JobAddress.class);
		
		System.out.println(jhong);
		System.out.println(jlee);
		System.out.println(jkim);
	}
}
