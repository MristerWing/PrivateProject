package com.java.aop04;

import org.aspectj.lang.JoinPoint;

public class PAsepect {
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass().getName());
		System.out.println("강의장에 들어온다.");
	}

	// exception
	public void out(JoinPoint joinPoint) {
		System.out.println("you LATE, GET OUT!!!");
	}

	public void course(JoinPoint joinPoint) {
		System.out.println("Listen to a lecture");
	}

	public void after(JoinPoint joinPoint) {
		System.out.println("강의장을 나간다.");
	}
}
