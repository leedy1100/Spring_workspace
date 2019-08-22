package com.test08;

public class LzTV implements TV {

	public LzTV() {
		System.out.println("Lz TV 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("Lz TV power on");

	}

	@Override
	public void powerOff() {
		System.out.println("Lz TV power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("Lz TV volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("Lz TV volume down");

	}

}
