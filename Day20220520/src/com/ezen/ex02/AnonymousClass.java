package com.ezen.ex02;

interface Printable { 
	void print();
}

class Papers {
	
	private String con;
	public Papers(String s) { con = s; }
	
	
	public  Printable getPrinter(){
		
		return new Printable() {   //익명 클래스 정의 와 인스턴스 생성

			@Override
			public void print() {
				System.out.println(con);
			}
			
		};
		
	}
	
}

public class AnonymousClass {

	public static void main(String[] args) {
		Papers p = new Papers("message java2!!");
		Printable prn = p.getPrinter();   //
		prn.print();
	}
}
