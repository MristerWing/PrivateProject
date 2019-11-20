package com.java.di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");

		AA a = (AA) ctx.getBean("a");
		AA b = (AA) ctx.getBean("b");
		System.out.println(b.toString());

		ctx.close();
	}

}
