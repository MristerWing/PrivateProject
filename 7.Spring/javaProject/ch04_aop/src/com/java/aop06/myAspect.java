package com.java.aop06;

import org.aspectj.lang.ProceedingJoinPoint;

public class myAspect {
	public Object advice(ProceedingJoinPoint joinPoint) {
		Object returnValue = "FIRE!";
		System.out.println("\n문을 열고 집에 들어온다.");

		try {
			System.err.println(joinPoint.getTarget().getClass().getName());
			System.err.println(joinPoint.getSignature().getName());

			returnValue = joinPoint.proceed();

		} catch (Throwable e) {
			System.out.println("화재 발생시: 119 신고");
		} finally {
			System.out.println("문을 열고 집을 나온다.");
		}

		return returnValue;
	}
}
