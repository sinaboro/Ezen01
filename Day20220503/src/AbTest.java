abstract class AA{  //추상클래스
	
	int a=10;
	
	void test() {
		System.out.println("AAAAAAAA");
	}
	
	abstract void func();  //추상메소드  신영
	abstract void func1();  //추상메소드 수연
	abstract void func2();  //추상메소드 부영
	abstract void func3();  //추상메소드 수진
	abstract void func4();  //추상메소드 수정
}


abstract class BB extends AA{
	void func() {
		System.out.println("BBBBBBBBB");
	}
}
class CC extends BB{

	@Override
	void func1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void func2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void func3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void func4() {
		// TODO Auto-generated method stub
		
	}
	
}

public class AbTest {
	public static void main(String[] args) {
			AA a = new CC();
			System.out.println(a.a);
			a.test();
			a.func();
	}
}

