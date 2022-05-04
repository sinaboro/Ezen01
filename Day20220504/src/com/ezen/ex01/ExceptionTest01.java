package com.ezen.ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest01 {

	public static void main(String[] args) throws Exception {
		int a = 100;
		int b ;
		
		try {
			
			b= a/10;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("무조건 실행");
		}
		
			
		System.out.println("dafdsafsdaf");
	} // main메서드의 끝

	static void method1() throws Exception {
		throw new Exception();
	}
}
