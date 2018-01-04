package com.test.demo.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
	
	@Pointcut("execution(* com.test.demo.service.impl.*Service*.*(..))")
	public void pointCut() {
	}
	
	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		logger.info("after aspect executed");
	}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		logger.info("before aspect executing,args is");
		for(Object arg:args){
			logger.info(arg.toString());

		}
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		logger.info("afterReturning executed, return result is "
				+ returnVal);
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("around start..");
		Object object = null;
		try {
			object = pjp.proceed();
		} catch (Throwable ex) {
			logger.info("error in around");
			throw ex;
		}
		logger.info("around end");
		return object;
	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error) {
		logger.info("error:" + error);
	}

}
