public class InheritanceTest {

	public static void main(String[] args) {
		
		B c =  new C(10,20,30);
//		A c =  new A();
		//C c = new A();
		
		System.out.println(c.a);
		c.testA();
		
//		B cc = (B) c;
		
//		System.out.println(c.a);
//		System.out.println(cc.b);
		//System.out.println(cc.c);
		
	//상위클래스 참조변수는 하위클래스 참조가능
	//하위클래스 참조변수는 상위클래스 참조불가
	
	}

}
