package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV  implements TV {
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("LgTV 생성자");
	}
	public LgTV(Speaker speaker, int price) {
		System.out.println("LgTV 생성자");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("LgTV---전원 켠다." + " 가격 :  " + price);
		
	}

	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}

	public void volumeUp() {
		System.out.println("LgTV---소리 올린다.");
	}

	public void volumeDown() {
		System.out.println("LgTV---소리 내린다.");
	}
}
