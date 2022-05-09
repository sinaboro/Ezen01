package com.ezen01;

final class Card{
	String kind;
	int num;
	
	public Card() {
		this("SPADE",1);
	}
	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "Card [kind=" + kind + ", num=" + num + "]";
	}
	
}
public class ClassEx1 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		Card c = new Card();
//		System.out.println(c);
		
//		Class cObj = c.getClass();
		Class cObj = Class.forName("com.ezen01.Card");
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
	}
	
}
