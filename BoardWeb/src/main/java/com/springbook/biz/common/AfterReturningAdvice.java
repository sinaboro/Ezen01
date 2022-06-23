package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) { 
			//returnObj는 UserVO참조하거나 UserVO를 자손을 이면 True
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}
		System.out.println("[사후 처리] " + method  + "리턴값 : " + returnObj.toString());
	}
}
