class A {
	int a=1;
	public A() {}
	public A(int a) {
		this.a = a;
	}
	void tsetA() {
		System.out.println("tsetA");
	}
	void tset() {
		System.out.println("tsetA");
	}
	
}

class B extends A {
	int b = 2;
	
	public B() {}
	public B(int a, int b) {
		super(a);
		this.b = b;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("eq B");
		return super.equals(obj);
	}
	
	void tsetB() {
		System.out.println("tsetB");
	}
	void tset() {
		System.out.println("tsetB");
	}
}

class C extends B {
	int c = 3;
	
	public C() {}
	public C(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}
	void tsetC() {
		System.out.println("tsetC");
	}
	void tset() {
		System.out.println("tsetC");
	}
}