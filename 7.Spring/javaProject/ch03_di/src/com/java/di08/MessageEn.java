package com.java.di08;

public class MessageEn implements Message {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

}
