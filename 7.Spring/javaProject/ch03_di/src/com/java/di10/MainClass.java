package com.java.di10;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/di10/appCTX.xml");

		IAdmin admin = (IAdmin) ctx.getBean("admin");
		admin.disp();

		ctx.close();
	}
}
