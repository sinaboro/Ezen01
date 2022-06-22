package polymorphism;

public class SoniTV  implements TV{

	public SoniTV() {
		System.out.println("sony");
	}
	@Override
	public void powerOn() {
		System.out.println("SonyTV---전원 켠다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV---전원 끈다.");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SonyTV---소리 올린다.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV---소리 내린다.");
	}

}
