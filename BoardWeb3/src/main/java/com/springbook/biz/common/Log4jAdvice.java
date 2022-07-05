package com.springbook.biz.common;

import org.springframework.stereotype.Component;

//@Component("log")
public class Log4jAdvice {
	public void printLogging() {
		System.out.println("[공통 로그-Log4] 비즈니스 로직 수행 전 동작");
	}
}
