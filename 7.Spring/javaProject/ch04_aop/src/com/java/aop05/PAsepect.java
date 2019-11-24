package com.java.aop05;

import org.aspectj.lang.ProceedingJoinPoint;

public class PAsepect {
	public void getAround(ProceedingJoinPoint joinPoint) {
		// before
		System.out.println(joinPoint.getTarget().getClass().getName());
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("강의장에 들어온다.");

		try {
			joinPoint.proceed();

			// returning
			System.out.println("lecture...");
		} catch (Throwable e) {
			// throwing
			System.out.println("you LATE, GET OUT!!!");
		} finally {
			// after
			System.out.println("강의장을 나간다.");
		}
	}
}
