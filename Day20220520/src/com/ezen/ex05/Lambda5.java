package com.ezen.ex05;

import java.util.Random;

@FunctionalInterface  //함수형 인터페이스 ..........추상메소드 1개만 존재
interface Cenerator {
	int rand();
}

class Abc implements Cenerator{

	@Override
	public int rand() {
		return 0;
	}
}

public class Lambda5 {
	public static void main(String[] args) {
		
		Cenerator gen = () -> { 
			
			Random rand = new Random();
			return rand.nextInt(50);
		};
		
		int num = gen.rand();
		System.out.println(num);
	}
}
