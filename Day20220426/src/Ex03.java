public class Ex03 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
	    Car c3 = new Car();
	    c1.num++;
	    c2.num +=2;
	    c3.num +=5;
	    System.out.println("c1 : " + c1.num);
	    System.out.println("c2 : " + c2.num);
	    System.out.println("c3 : " + c3.num);
	    
	    
	    Car c4 =  new Car();
	    c4.func();
	  
	    Car car5 = new Car(c4);

	    System.out.println(car5.num);
	    
	    Car2 c10 = Car2.getInstance();
	    
	 //   Car2 c200 =  new Car2():
	    
	    c10.num++;
	    System.out.println("c10 : " + c10.num);
	    
	    Car2 c11 = Car2.getInstance();
	    Car2 c12 = Car2.getInstance();
	    c11.num++;
	    System.out.println("c11: " + c11.num);
	    System.out.println("c10 : " + c10.num);
	    System.out.println("c12 : " + c12.num);
	}
}
class Car{
	static int  num=10;
	
	public Car() {
		System.out.println("car 생성자");
	}
	
	public Car(Car a) {
		System.out.println("----------------");
	}
	void func() {
		System.out.println("func");
	}
}

class Car2{  // 디자인패턴 >> 싱글톤
	
	private  static Car2 car2 = new Car2();
	
	int num=100;
	
	private Car2() {
		System.out.println("car2 생성자");
	}
	
	public static Car2 getInstance() {
//		if(car2 == null)
//			car2 = new Car2();  //생성자 호출
		return car2;
	}
}
