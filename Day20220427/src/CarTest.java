import lombok.ToString;

public class CarTest {
	public static void main(String[] args) {
		
		Sedan se = new Sedan("white",5,4);
//		se.color = "white";
//		se.passenger = 5;
//		se.tire = 4;
		
		System.out.println(se.color + ", " + se.passenger + "," + se.tire);
		se.run();
		Bus bu = new Bus();
		bu.passenger = 15;
		bu.tire = 6;
		System.out.println(bu.passenger + "," + bu.tire);
		
		Sports ss = new Sports(2,4,2,"Red", 1000);
		System.out.println(ss.color + ", " + ss.passenger + "," + ss.tire +","+ ss.seat + ", "  + ss.sports);
	}
}

class Sedan extends Car{
	String color;
	
	public Sedan(String color, int passenger, int tire) {
		super(passenger,tire, 4);  //상위클래스 생성자 호출
		this.color = color;
//		this.passenger = passenger;
//		this.tire = tire;
		System.out.println("Sedan() 생성자");
	}
	
	public Sedan(int passenger, int tire , int seat, String color) {
		super(passenger, tire, seat );
		this.color = color;
	}
	
	public Sedan() {}
}

class Sports extends Sedan{
	int sports ;
	
	public Sports() {}
	
	public Sports(int passenger, int tire , int seat, String color, int sports) { 
		super(passenger,tire, seat ,color);
		this.sports = sports;
	}
}
class Car {
	int passenger;
	int tire;
	int seat;
	
	public Car(int passenger, int tire, int seat) {
		this.passenger = passenger;
		this.tire = tire;
		this.seat = seat;
		System.out.println("Car() 생성자");
	}
	public Car() {
		this(10,4,4);
		System.out.println("Car()생성자");
	};
	
	
	void run() {
		System.out.println("run()");
	}
	void stop() {}
	
}

class Bus extends Car{
	void passengerLoad() {};
}
class Truck extends Car{
	void objectLoad() {};
}