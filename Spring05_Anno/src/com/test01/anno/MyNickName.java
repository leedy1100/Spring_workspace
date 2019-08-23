package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickName {

	@Autowired
	private NickName nickName;

	public MyNickName() {
		super();
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	public NickName getNickName() {
		return nickName;
	}

	public String toString() {
		return "나의 " + nickName;
	}
}
