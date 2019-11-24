package com.java.aop06;

import java.util.Random;

public class Male implements Person {

	@Override
	public String doSomething() throws Throwable {
		System.out.println("컴퓨터로 게임을 함");

		boolean check = new Random().nextBoolean();

		if (check) {
			throw new Exception("FIRE!");
		}

		return "I'm Ironman.";
	}

}
