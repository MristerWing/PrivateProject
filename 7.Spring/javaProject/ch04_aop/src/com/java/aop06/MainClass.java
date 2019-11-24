package com.java.aop06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/aop06/appCTX.xml");

		Person male = (Person) ctx.getBean("male");
		String maleWhoAreYoy = male.doSomething();
		System.out.println(maleWhoAreYoy);

		Thread.sleep(1000);

		Person female = (Person) ctx.getBean("female");
		String femaleWhoAreYpu = female.doSomething();
		System.out.println(femaleWhoAreYpu);

		ctx.close();

	}

}
