package com.ezen.ex03;

import java.util.concurrent.atomic.LongAdder;

class Box<T extends Number>{  //T에 올수 있는 대상은 Number이거나 Number를 상속한 객체만 가능
//class Box<T>{  //T에 올수 있는 대상은 Number이거나 Number를 상속한 객체만 가능
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
	
	public int toIntValue() {
		return ob.intValue();    //
	}
}

class Person{}
public class BoundedBox {

	public static void main(String[] args) {
		
		Box<Double> aBox = new Box<>();
//		Box<String> sBox = new Box<>():
		aBox.set(new Double(10.5));
		
		System.out.println(aBox.get());
	}

}
