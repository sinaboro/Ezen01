
public class Test01 {

	public static void main(String[] args) {
		A  a = new  A();
		a.func();
	}

}


class A {
	public void func() {
		System.out.println("A");
	}
}
class B extends A{
	public void func() {
		System.out.println("B");
	}
}
class C extends A{
	public void func() {
		System.out.println("C");
	}
}
class D extends A{
	public void func() {
		System.out.println("D");
	}
}
