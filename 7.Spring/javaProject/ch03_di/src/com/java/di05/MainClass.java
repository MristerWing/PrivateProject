package com.java.di05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/di05/appCTX.xml");

		StudentInfo studentInfo = (StudentInfo) ctx.getBean("studentInfo");

		studentInfo.print();

		ctx.close();
	}

}
