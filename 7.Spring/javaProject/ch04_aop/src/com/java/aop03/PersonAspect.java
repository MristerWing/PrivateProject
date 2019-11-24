package com.java.aop03;

import org.aspectj.lang.JoinPoint;

public class PersonAspect {

	// JoinPoint에 핵심 클래스가 넘어온다.

	public void wakeUp(JoinPoint joinPoint) {
		System.out.println(
				joinPoint.getTarget().getClass().getName() + "가 일어났습니다!");
	}

	public void sleep(JoinPoint joinPoint) {
		System.out.println(
				joinPoint.getTarget().getClass().getName() + "가 잠이듭니다.zzzz");
	}

}
