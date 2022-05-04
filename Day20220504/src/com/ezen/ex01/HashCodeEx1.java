package com.ezen.ex01;

class HashCodeEx1 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		System.out.println(v1.equals(v2));
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
	}
}


class Value2 {
	int value;

	Value2(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		return value == ((Value2)obj).value;
	}
}