package com.test03;

import org.springframework.stereotype.Component;

@Component("lz")
public class LzTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("Lz tv power on");

	}

	@Override
	public void powerOff() {
		System.out.println("Lz tv power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("Lz tv volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("Lz tv volume down");

	}

}
