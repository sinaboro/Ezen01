package com.springbook.view.controller;

public class A {
	public void test() {
		System.out.println("AAAAAAAAAAA");
	};
}

class B extends A{
	public void test() {
		System.out.println("BBBBB");
	};
}

class C extends A{
	public void test() {
		System.out.println("CCCCCCCCCCCC");
	};
}

class D{
	public static void main(String[] args) {
		A a = new B();
		a.test();
	}
	
}