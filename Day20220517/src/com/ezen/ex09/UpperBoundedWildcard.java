package com.ezen.ex09;

class Box<T> {
	private T ob;
	public T getOb() { return ob; }
	public void setOb(T ob) { this.ob = ob; }
	
	@Override
	public String toString() {
		return ob.toString();
	}
}

class Unboxer {
	
	public static void peekBox(Box<? extends Number> box) {  //와일드카드 상한제한
		System.out.println(box);
	}
}
public class UpperBoundedWildcard {

	public static void main(String[] args) {
		Box<Integer> box = new Box<>();
		box.setOb(123);
		
		System.out.println(box.getOb());
		
		Unboxer.peekBox(box);
		
	}
}
