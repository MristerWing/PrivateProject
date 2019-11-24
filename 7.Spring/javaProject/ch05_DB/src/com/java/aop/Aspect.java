package com.java.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect {

	public static Logger logger;
	public static final String logMsg = "LogMsg---------------------------";

	public Object advice(ProceedingJoinPoint joinPoint) {
		Object resultValue = null;
		System.out.println(
				"============================START==============================");

		try {
			logger = Logger.getLogger(joinPoint.getTarget().getClass().getName()
					+ joinPoint.getSignature().getName());

			resultValue = joinPoint.proceed();
			logger.info(logMsg + "obj:" + resultValue);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println(
				"=============================END===============================");

		return resultValue;
	}
}
