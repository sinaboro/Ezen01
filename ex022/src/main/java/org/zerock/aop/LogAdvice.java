package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect  //해당 객체가 Aspect를 구현했다.
@Component
@Log4j
public class LogAdvice {
	
	//@Before( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("--------------------------------");
	}
	
	//@Before( "execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1,str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info(str1);
		log.info(str2);
	}
	
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))",
			throwing = "exception")
	public void logException(Exception exception) {
		log.info(" exception : " + exception);
	}
	
	@Around( "execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		
		long start = System.currentTimeMillis();
		log.info(pjp.getTarget().getClass().getName());
		log.info(Arrays.toString(pjp.getArgs()));
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		log.info("time : " + (end - start));
		return result;
	}
	
	
	
	
	
	
	
	
	
}
