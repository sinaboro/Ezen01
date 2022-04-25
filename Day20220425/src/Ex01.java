

//인스턴스 변수는 메소드는  객체가 생성되야 사용 가능
//인스턴스 변수 및 메소드는  사용 가능 대상이 인스턴스변수 인스턴스메소드 와 클래스변수 , 클래스 메소드 접근 가능
//클래스변수와 클래스메소드는 객체 생성전 method area 영역에 생성됨, 따라서 클래스변수 메소드는 생성되지 않은 인스턴스변수, 인스턴스 메소드
// 접근 불가


public class Ex01 {

	static int num=100;
	int i=10;
	
		
	 void func() {
		 i++;
		 num++;
		 System.out.println(i);
	}
	 
	 static void func2() {
		  //i++;
		 
		 num++;
	 }
}


class Abc{
	public static void main(String[] args) {
		Ex01 ex =  new Ex01(); 
		ex.func();
		System.out.println(ex.i);
	}
}