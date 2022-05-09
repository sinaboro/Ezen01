package com.ezen;
//상위클래스 참조변수는 하위클래스 참조 가능
//하위클래스 참조변수는 상위클래스 참조 불가
//단. 상위클래스가 참조한 하위클래스를 하위클래스 참조변수에게 타입변환 후 참조하게 할 수 있다.

public class Test {
	public static void main(String[] args) {
		Object obj = new BBB(10);  //10
		
		int i= 5;
		
		Integer io = 7; // 박싱 new Integer(7); 
		
		int sum = io + 5;  //언박싱 io.intValue() + 5;
		
	}
}

class D {
	int d;
}
class F {}
class AAA {
	int a;
	void funcA() {}
}

class BBB extends AAA {
	int b;
	public BBB(Object o) {
		
		if(o instanceof D) {
			D d = (D)o;
			d.d = 10;
		}else if( o instanceof F) {
			F f = (F)o;
		}
			
		
	}
	void funcB(Object o) {}
}












