package com.test01.anno;

import org.springframework.stereotype.Component;

// <bean id="nickName" class="com.test01.anno.NickName /> 첫글자 소문자
@Component
public class NickName {

	public NickName() {

	}

	public String toString() {
		return "별명 : 홍길동";
	}
}
