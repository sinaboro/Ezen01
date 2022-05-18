package com.ezen.ex11;

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
	
	public static void peekBox(Box<? super Integer> box) {  //Integer, Number, Object
		System.out.println(box);
	}
}
public class LowerBoundedWildcard {

	public static void main(String[] args) {
		Box<Integer> box = new Box<>();
		box.setOb(123);
		Unboxer.peekBox(box);

		Box<Number> box2 = new Box<>();
		box2.setOb(12.4);
		Unboxer.peekBox(box2);
		
		Box<Object> box3 = new Box<>();
		box3.setOb("string");
		Unboxer.peekBox(box3);
		
	}
}
