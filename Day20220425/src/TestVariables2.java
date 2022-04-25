
public class TestVariables2 {

	public static void main(String[] args) {
//		Variables2 var = new Variables2();
//		System.out.println(var.iv);
		
		System.out.println(Variables2.cv);  //클래스 변수는 객체 생성하지않고 접근 가능 >> 이유는 객체생성 전에 메모리 공간 올라가있음
		
		Variables2 var2 = new Variables2();
		
		Variables2.method2(); 
		
//		System.out.println(Variables2.cv++);  //final static 붙어있는 클래스 변수는 수정 불가
//		System.out.println(Variables2.cv++);
		
	}

}


class Variables2{
	int iv;  //인스턴스변수 ,멤버변수
 
	final static int cv=100;  //클래스변수, 정적변수, 공유변수
    
    void method() {
    	int lv=0;   //지역변수
    }
    
    static void method2() {
    	int lv=0;   //지역변수
    	System.out.println("iv = " + lv);
    }
}