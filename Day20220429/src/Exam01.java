class Exam01 {
	public static void main(String[] args) {
		Parent p = new Child();
		
		System.out.println("p.x = " + p.x);
		p.method2();
	}
}

class Parent {
	int x = 100;

	void method2() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;

	void method2() {
		System.out.println("Child Method");
	}
}