package com.ezen;

import lombok.Getter;
import lombok.Setter;

public class CarTest {
	public static void main(String[] args) {
		
		Sedan se = new Sedan();
		se.setColor("red"); 
		System.out.println(se.getColor());
		
		se.setPassenger(4);
		System.out.println(se.getPassenger() + "명");
		
		Sedan se2 = new Sedan("bule", 2, 4, 3);
		System.out.println(se2.getPassenger() + "명");
		System.out.println(se2.getColor());
		
		Sports sp = new Sports();
		sp.setColor("red");
		System.out.println(sp.getColor());
		
		Sports sp2 = new Sports("yollow", 2, 4, 1, 5000);
		
	}
}

@Getter
@Setter
class Car{
	
	private int passenger;
	private int tire;
	private int seat;
	
	public Car() {}
	public Car(int passenger ,int tire, int seat ) {
		System.out.println("Car()생성자");
		this.passenger  = passenger;
		this.tire  = tire;
		this.seat = seat;
	}
	void run() {}
	void stop() {}
	
}
class Sports extends  Sedan{
	int horsepower;
}

class Sedan extends Car {
	
	private String color;
	
	public Sedan() {} 
	public Sedan(String color, int passenger, int tire, int seat) {
		super(passenger, tire, seat);  //상위클래스 생성자에게 전달....Car생성자에게 전달
		System.out.println("Sedan()생성자");
		this.color = color;
		setPassenger(passenger);
		setTire(tire);
		setSeat(seat);
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	void gas() {}
}

class Bus extends Car{
	int passengerCount;
	void passengerLoad() {}
}

class Truck extends Car{
	int load;
	void ObjectLoad() {}
}
