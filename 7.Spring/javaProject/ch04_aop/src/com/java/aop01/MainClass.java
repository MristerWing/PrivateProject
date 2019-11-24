package com.java.aop01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/aop01/appCTX.xml");

		// 각 비지니스 로직의 공통된 핵심 부분을 가지고 하나의 모듈을 만드는것, AOP
		PersonAspect baby = (PersonAspect) ctx.getBean("pBaby");
		baby.advice();
		System.out.println();

		PersonAspect father = (PersonAspect) ctx.getBean("pFather");
		father.advice();
		System.out.println();

		PersonAspect mother = (PersonAspect) ctx.getBean("pMother");
		mother.advice();

		ctx.close();
	}

}
