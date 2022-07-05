package polymorphism;

public class AlapaTV  implements TV{
	private int num;
	
	@Override
	public void powerOn() {
		System.out.println("Alapa powerOn");
		System.out.println("num : " + num);
	}

	@Override
	public void powerOff() {
		System.out.println("Alapa powerOff");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("Alapa volumeUp");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("Alapa volumeDown");
		
	}

}
