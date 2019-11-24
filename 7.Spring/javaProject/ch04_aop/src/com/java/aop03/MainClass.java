package com.java.aop03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/aop03/appCTX.xml");

		// 각 비지니스 로직의 공통된 핵심 부분을 가지고 하나의 모듈을 만드는것, AOP
		Person baby = (Person) ctx.getBean("baby");
		baby.work();
		System.out.println();

		Person father = (Person) ctx.getBean("father");
		father.work();
		System.out.println();

		Person mother = (Person) ctx.getBean("mother");
		mother.work();

		ctx.close();
	}

}
