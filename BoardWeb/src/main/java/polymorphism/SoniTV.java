package polymorphism;

public class SoniTV  implements TV{

	@Override
	public void powerOn() {
		System.out.println("SoniTV---전원 켠다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SoniTV---전원 끈다.");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SoniTV---소리 올린다.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SoniTV---소리 내린다.");
	}

}
