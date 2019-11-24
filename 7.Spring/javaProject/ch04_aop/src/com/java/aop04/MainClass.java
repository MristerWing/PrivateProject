package com.java.aop04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/aop04/appCTX.xml");

		Person teacher = (Person) ctx.getBean("teacher");
		teacher.work();

		try {
			Person student = (Person) ctx.getBean("student");
			student.work();
		} catch (Exception e) {

		}

		ctx.close();
	}

}
