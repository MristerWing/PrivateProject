package com.java.di07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// 배열도 된다.
		String[] config = { "classpath:com/java/di07/appCTX01.xml",
				"classpath:com/java/di07/appCTX02.xml" };

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				config);

		AAA aaa = (AAA) ctx.getBean("aaa");
		System.out.println(aaa.toString());

		BBB bbb = (BBB) ctx.getBean("bbb");
		System.out.println(bbb.toString());

		ctx.close();
	}
}
