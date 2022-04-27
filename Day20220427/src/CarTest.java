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
	}
}

class Sedan extends Car{
	String color;
	
	public Sedan(String color, int passenger, int tire) {
		super(passenger,tire,0);
		this.color = color;
//		this.passenger = passenger;
//		this.tire = tire;
		System.out.println("Sedan() 생성자");
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
	public Car() {};
	
	void run() {
		System.out.println("run()");
	}
	void stop() {}
	
}


@ToString
class Bus extends Car{
	void passengerLoad() {};
}

@ToString
class Truck extends Car{
	void objectLoad() {};
}