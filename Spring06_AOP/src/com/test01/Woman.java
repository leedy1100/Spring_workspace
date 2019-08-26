package com.test01;

public class Woman {

	void classWork() {
		System.out.println("출석카드 찍는다.");		//ccc (공통 관심사항)
	
		try {
			System.out.println("컴퓨터 켜서 쇼핑한다.");	// cc (핵심 관심사항)
		} catch(Exception e) {
			System.out.println("쉬는 날이다.");
		} finally {
			System.out.println("집에 간다.");
		}	
	}
}
