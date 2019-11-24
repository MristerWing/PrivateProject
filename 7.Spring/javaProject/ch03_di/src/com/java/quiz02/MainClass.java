package com.java.quiz02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author KimJinsu
 * @Date 2019. 11. 21.
 * @Infomation MainClass
 */
public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/java/quiz02/appCTX.xml");

		// 개인: 이름, 국어, 영어, 수학
		// 반총점 반평균

		SungjukBan sungjukBan = (SungjukBan) ctx.getBean("sungjuBan");
		sungjukBan.banDisp();

		ctx.close();

	}

}
