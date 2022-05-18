package com.ezen.ex12;

class Box<T> {
	private T ob;
	public T getOb() { return ob; }
	public void setOb(T ob) { this.ob = ob; }
	
	@Override
	public String toString() {
		return ob.toString();
	}
}
class Toy {
	@Override
	public String toString() {
		return "I am Toy";
	}
}

// Robot r = new Toy();
//public static void outBox(Box<? extends Toy> box)
class Robot extends Toy {}

class BoxHandler {                                       //box 전달 대상은 Toy, Robot 가능
	public static void outBox(Box<? extends Toy>   box) {  //box에는 전달 가능 인스턴스는 Toy또는 Toy상속한 아이들
		Toy t = box.getOb();         //box >> Robot
		System.out.println(t);
		//box.setOb(new Toy());   //Robot
	}
	
	public static void inBox(Box<? super Toy> box, Toy t) {  //box 대상은 Toy, Object
		box.setOb(t);  //Object
		
		// t = box.getOb();  
//		System.out.println(t2);
	}
}
public class BoundedWildCardBsse {

	public static void main(String[] args) {
		Box<Toy> box = new Box<>();
		BoxHandler.inBox(box, new Toy());
	
		BoxHandler.outBox(box);
	}
}
