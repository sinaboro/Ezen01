package com.ezen.ex01;

import java.util.Scanner;

class ReadAgeExcption extends Exception{
	public ReadAgeExcption() {
		super("유효하지 않은 나이가 입력됬습니다.");
	}
}

public class AgeExcption {

	public static void main(String[] args) {
		System.out.println("나이 입력 : ");
		
		try {
			int age = readAge();
			System.out.println("입력된 나이 : " + age);
			
		}catch(ReadAgeExcption e) {
			System.out.println(e.getMessage());
		}
	}

	private static int readAge() throws ReadAgeExcption {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		if( age<0)
			throw new ReadAgeExcption();
		return age;
	}
}
