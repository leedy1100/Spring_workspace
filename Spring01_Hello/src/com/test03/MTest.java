package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// 1. 
		// Resource res = new FileSystemResource("src/com/test03/beans.xml");
		
		// 2.
		//  Resource res = new ClassPathResource("com/test03/beans.xml");
		
		// 최근형식
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean bean = (MessageBean) factory.getBean("bean01");
		bean.sayHello("SSpring");
		
		bean = (MessageBean) factory.getBean("bean02");
		bean.sayHello("쓰프링");
		
		/*
		 
		1. ApplicationContext, ClassPathXmlApplicationContext
		   스프링의 ApplicationContext 객체는 스프링 컨테이너의 인스턴스 이다.
		   스프링은 ApplicationContext 인터페이스의 몇가지 기본적인 구현을 제공한다.
		   
		   ClassPathXmlApplicationContext : Xml 형식의 독립형 어플리케이션에 적합
		   - 지정된 classpath에서 xml 파일을 읽어서 생성
		   
		   
		2. contents, contexts, container
		   contents : 기능
		   contexts : 기능을 구현하기 위한 정보
		   container : 담을 객체
		 
		 */
		
	}
}
