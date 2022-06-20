package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV °´Ã¼ »ý¼º");
	}

	public void powerOn() {
		System.out.println("LgTV---Àü¿ø ÄÒ´Ù.");
	}

	public void powerOff() {
		System.out.println("LgTV---Àü¿ø ²ö´Ù.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
