package com.ezen.ex06;

import java.util.function.Function;

public class FunctionEx1 {

	public static void main(String[] args) {
		
		Function<String, Integer> f = s -> s.length();
		
		System.out.println(f.apply("java Function"));
		
		System.out.println(f.apply("java"));
	}

}
