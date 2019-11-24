package com.java.di09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * LifeCycle = create container => configure container => initialization
		 * bean => use container => exit container
		 */

		System.out.println("1. create container-------------");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

		System.out.println("2. configure container-------------");
		ctx.load("classpath:com/java/di09/appCTX.xml");

		System.out.println("3-1. initialization bean-------------");
		ctx.refresh(); // call method

		System.out.println("4. use container-------------");
		IMsg msg = (IMsg) ctx.getBean("msg");
		System.out.println(msg.toDisp());

		// just destroy bean
		// ctx.destroy();

		// destroy bean and return resource
		ctx.close(); // call method
		System.out.println("5-2. exit container-------------");
	}

}
