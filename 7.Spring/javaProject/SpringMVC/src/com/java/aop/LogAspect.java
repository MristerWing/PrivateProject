package com.java.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author KimJinsu
 * @Date 2019.11.25
 * @information AOP기능 구현 + Logger
 */
public class LogAspect {
	public static Logger logger = Logger.getLogger(LogAspect.class.getName());
	public static final String logMsg = "LogMsg---------------------------";

	public Object advice(ProceedingJoinPoint joinPoint) {
		Object loggingValue = null;
		System.out.println(
				"============================START==============================");

		try {
			String loggingClassName = joinPoint.getTarget().getClass()
					.getName();
			String loggingMethodName = joinPoint.getSignature().getName();
			logger = Logger.getLogger(loggingClassName + loggingMethodName);

			loggingValue = joinPoint.proceed();
			logger.info(logMsg + "result:" + loggingValue);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println(
				"=============================END===============================");

		return loggingValue;
	}
}
