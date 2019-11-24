package com.java.di09;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Msg implements IMsg, InitializingBean, DisposableBean {
	private int number1;
	private int number2;

	public Msg() {
	}

	public Msg(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toDisp() {
		return "number1=" + number1 + ", number2=" + number2;
	}

	@Override
	public void destroy() throws Exception {
		// if destroy bean, call this method
		System.out.println("5-1. destroy()-------------");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// if initialization bean, call this method
		System.out.println("3-2. afterPropertiesSet()-------------");
	}

}
