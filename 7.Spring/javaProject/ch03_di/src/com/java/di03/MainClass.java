package com.java.di03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AA a = new AA(10, 20);
		BB b = new BB();
		b.setA(77);
		b.setB(88);
		
		CC c = new CC(a);
		c.setBb(b);
		System.out.println(c.toString());
		
		CC d = new CC();
		d.setBb(b);
		System.out.println(d.toString());

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		
		CC ccc = (CC) ctx.getBean("c");
		
		System.out.println(ccc.toString());
		
		ctx.close();
	}

}
