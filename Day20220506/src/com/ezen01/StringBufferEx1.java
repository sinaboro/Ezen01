package com.ezen01;

class StringBufferEx1 {
	public static void main(String[] args) {
	
		StringBuilder sb  = new StringBuilder("0123456");
		
		sb.delete(3, 6);
	//	System.out.println(sb2);
		System.out.println(sb);
		
		sb.insert(3, "a");
		System.out.println(sb);
		sb.insert(1,10.5);
		System.out.println(sb);
		
		sb.replace(1, 4, "abcd");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
	}
}
