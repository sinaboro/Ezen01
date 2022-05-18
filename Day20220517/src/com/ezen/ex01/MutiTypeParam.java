package com.ezen.ex01;

/*
 * E : Element
 * K : Key
 * N : Number
 * T : Type
 * V : value
 */
class DBox<L,R>{
	private L left;
	private R right;
	
	public void set(L l, R r) {
		left = l;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + "&" + right;
	}
}

/*
 * class DBox<String,Integer>{
	private StringL left;
	private Integer right;
	
	public void set(StringL l, Integer r) {
		left = l;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + "&" + right;
	}
}
 */

public class MutiTypeParam {

	public static void main(String[] args) {

		DBox<String, Integer> box = new DBox<String, Integer>();
		
		box.set("Apple", 20);  //new Integer(20)
		System.out.println(box);
		box.set("Apple2", new Integer(50));
		System.out.println(box);
		
		//box.set(20, "Apple");
		
	}

}
