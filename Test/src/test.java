class A{
	int a;
	void funcA() {
		System.out.println("aaaa");
	}
	
	 A(int a){
		this.a  = a;
	 }
	 A(){};
}

class B extends A{
	int b;
	void funcA() {
		super.funcA();
		System.out.println("bbbb");
	}
	
	B(){};
	B(int a,int b){
		super(a);
		this.b = b;
	};
}

class C extends B{
	int c;
	
	void funcA() {
		
		super.funcA();
		
		System.out.println("cccc");
	 }
	
	public C() {
		this(0,0,0);
	}
	public C(int i, int j) {
		this(i,j,0);
	}
	public C(int i, int j, int k) {
		super(i,j);
		this.c = k;
	}

}

class D extends A {
	int d;
	D(){
		super(100);
	}
	void funcD() {System.out.println("DDDD");}
}

public class test {

	public static void main(String[] args) {
		
		int sum=0;
		try {
		int a = 10/0;
		int b;
			b = a/0;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i=0; i<=100; i++)
			sum +=i;
	    System.out.println("sum : " + sum);
//		A a = new C(100,200,300);
//		
//		a.funcA();
	
		
	//	c.funcB();
	//	c.funcC();
	}

}
