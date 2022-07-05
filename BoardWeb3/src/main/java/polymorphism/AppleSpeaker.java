package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker  implements Speaker{

	public AppleSpeaker() {
		System.out.println("AppleSpeak 생성자");
	}
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker 소리 울린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker 소리 내린다.");
	}

}
