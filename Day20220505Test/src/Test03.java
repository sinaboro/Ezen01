
public class Test03 {

	public static void main(String[] args) {
		//상위클래스는 하위클래스 참조가능, 하위는 상위클래스 참조 불가
		
		A a = new A();
		a.tsetA();
		a.tset();
		
		A a1 = new B();
		a1.tsetA();
		a1.tset();
		
		A a2 = new C();
		a2.tsetA();
		a2.tset();
		
	//	System.out.println(a2.a);
		//메서드 오버라이딩.........
		
       		
		B bb = (B)a1;
		bb.tsetB();
		bb.tsetA();
		
		System.out.println(bb.a);
		System.out.println(bb.b);
		
		
//		C cc = a1;    // C cc = new B(); ==> 하위클래스가 상위클래스 참조할 수 없다.
//		C cc = a(x)
//		C cc = a1(x)
		C cc = (C)a2;  // C cc = new C();
		System.out.println(cc.a);
		cc.tsetB();
		
		
		//B b = new A();  -error
		B b1 = new B();
		B b2 = new C();
//		System.out.println(b2.a);

//		C c = new A(); -error
//		C c1 = new B(); -error
		C c2 = new C();
//		System.out.println(b2.a);
		
		Object obj1 = new C();
		C objC = (C)obj1;
		
	}

}


