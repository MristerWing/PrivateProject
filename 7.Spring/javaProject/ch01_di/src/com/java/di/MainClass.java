package com.java.di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// 클래스간 결합이 강해지고 의존성이 높아지면 코드 수정해야 하는 범위가 넓어진다.
		// => 클래스간의 결합도를 약하게 하고 의존성을 낮게 작성해야한다.
		
		/*
		 * Su su = new Su();
		 * 
		 * su.disp();
		 */

		// DI (Dependency Injection): 의존성에 대한 설계 패턴 / 외부로부터 전달받음.
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		
		Su appSu = (Su) ctx.getBean("su");
		appSu.disp();
		
		ctx.close();
	}

}
