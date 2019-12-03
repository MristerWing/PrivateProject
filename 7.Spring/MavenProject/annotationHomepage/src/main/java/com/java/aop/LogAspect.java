package com.java.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote Aspect for Log & Exception
 */
@Component
@Aspect
public class LogAspect {
	public static Logger logger = Logger.getLogger(LogAspect.class.getName());
	public static final String logMsg = "LogMsg---------------------------";

	@Around("within(com.java..*)")
	public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = null;

		System.out.println(
				"============================START==============================");

		try {
			String loggingClassName = joinPoint.getTarget().getClass()
					.getName();
			String loggingMethodName = joinPoint.getSignature().getName();
			logger = Logger.getLogger(loggingClassName + loggingMethodName);

			obj = joinPoint.proceed();

			logger.info(logMsg + "result:" + obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println(
				"=============================END===============================");

		return obj;
	}
}
