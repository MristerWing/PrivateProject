package com.java.di08;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author KimJinsu
 * @Date 2019. 11. 21.
 * @Infomation Spring Framework는 설계기반이 Interface이다.
 */
public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/di08/appCTX.xml");

		Message en = (Message) ctx.getBean("messageEn");
		en.sayHello("Spring");

		Message kr = (Message) ctx.getBean("messageKr");
		kr.sayHello("스프링");

		ctx.close();

	}

}
