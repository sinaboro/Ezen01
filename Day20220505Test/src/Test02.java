
public class Test02 {

	public static void main(String[] args) {
		Test02_1 t1 = new Test02_1();
		Test02_1 t2 = new Test02_1(10);
		Test02_1 t3 = new Test02_1(10,20);
		Test02_1 t4 = new Test02_1(10,20,30);
	}

}

class Test02_1{
	int a;
	int b;
	int c;
	
	public Test02_1() {  //0
		this(0,0,0);
	}
	public Test02_1(int a) {  //1
		this(a,0,0);
	}
	public Test02_1(int a, int b) {  //2
		this(a,b,0);
	}
	public Test02_1(int a,int b, int c) {  //3
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}