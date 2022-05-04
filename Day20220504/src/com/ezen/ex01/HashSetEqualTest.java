package com.ezen.ex01;

import java.util.HashSet;  //

public class HashSetEqualTest {

	public static void main(String[] args) {
		HashSet<Num> set = new HashSet();
		
		set.add(new Num(100));
		set.add(new Num(100));
		set.add(new Num(100));
		set.add(new Num(100));
		set.add(new Num(700));
		set.add(new Num(700));
		set.add(new Num(700));
		set.add(new Num(700));
		
		for(int i=0; i<set.size(); i++)
			System.out.println(set.toString());
	}
}

class Num{
	private int num;
	
	public Num(int n) {
		num = n;
	}
	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return num % 3;
	}
	@Override
	public boolean equals(Object obj) {
		
		System.out.println("equals");
		
		return num == ((Num)obj).num;
	}
	
	@Override
	public String toString() {
		return String.valueOf(num);
	}
}
