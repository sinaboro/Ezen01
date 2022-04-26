public class Ex03 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
	    Car c3 = new Car();
	    c1.num++;
	    System.out.println(c1.num);
	    System.out.println(c2.num);
	    System.out.println(c3.num);
	  
	    Car2 c10 = Car2.getInstance();
	    System.out.println(c10.num);
	}
}
class Car{
	int  num=10;
	public Car() {}
}

class Car2{
	
	private static Car2 car2 = null;
	
	int num=10000;
	
	private Car2() {}
	
	public static Car2 getInstance() {
		if(car2 == null)
			car2 = new Car2();  //생성자 호출
		return car2;
	}
}
