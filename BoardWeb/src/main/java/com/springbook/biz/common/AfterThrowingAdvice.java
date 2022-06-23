package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예의 처리] " + method + " , 예외 메시지 : " + exceptObj.getMessage());
	}
}
