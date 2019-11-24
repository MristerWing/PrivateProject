package com.java.aop06;

import java.util.Random;

public class Female implements Person {

	@Override
	public String doSomething() throws Throwable {
		System.out.println("TV 드라마를 시청함");

		boolean check = new Random().nextBoolean();

		if (check) {
			throw new Exception("FIRE!");
		}

		return "I'm cptMarvel.";
	}

}
