package com.ezen;

public class Exam01 {
	public static void main(String[] args) {
		animal an = new animal();
		animal an2 = new Mammal();
		
		animal an3 = new Person();
		an3.eat();
		an3.run();
		//an3.play();
		
		Person p =  (Person)an3;
		
		
		p.eat();
		p.run();
		p.play();
		
		Mammal m1 = (Mammal)an3;
		m1.eat();
		
		Object obj = new Person();
		Person p2 = (Person)obj;
		p2.eat();
	}
}

class animal{  //동물
	void eat() {
		System.out.println("동물이 먹는다");
	}
	void run() {}
}

class Person extends Mammal {  //사람
	void play() {}
	void eat() {
		System.out.println("사람이 먹는다");
	}
	void run()
	{
		System.out.println("사람이 달린다");
	}
}
class Mammal extends animal{  //포유류
	void eat() {
		System.out.println("포유류이 먹는다");
	}
}

class Whale extends Mammal {  //고래
	void eat() {
		System.out.println("고래가 먹는다");
	}
}

class Birds extends animal{ //조류
	void eat() {
		System.out.println("조류가 먹는다");
	}
}

class Penguin extends Birds { //펭궨
	void eat() {
		System.out.println("펭궨이 먹는다");
	}
}

class Sparrow extends Birds { //참새
	void eat() {
		System.out.println("참새가 먹는다");
	}
}