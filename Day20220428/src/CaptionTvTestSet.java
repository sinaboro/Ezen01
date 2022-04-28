class Tv2 {
	private boolean power; 	// 전원상태(on/off)
	private int channel;	// 채널

	
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	void power()        {   power = !power; }
	void channelUp()    { 	 ++channel;     }
	void channelDown()  {	 --channel;	    }
}

class CaptionTv2 extends Tv2 {
	private boolean caption;		// 캡션상태(on/off)
	
	public boolean isCaption() {
		return caption;
	}

	public void setCaption(boolean caption) {
		this.caption = caption;
	}

	void displayCaption(String text) {
		if (caption) {	// 캡션 상태가 on(true)일 때만 text를 보여 준다.
			System.out.println(text);
		}
	}
}

class CaptionTvTestSetter {
	public static void main(String args[]) {
		CaptionTv2 ctv = new CaptionTv2();
		//ctv.channel = 10;				// 조상 클래스로부터 상속받은 멤버
		ctv.setChannel(10);
		ctv.channelUp();				// 조상 클래스로부터 상속받은 멤버
//		System.out.println(ctv.channel);
		System.out.println(ctv.getChannel());
		ctv.displayCaption("Hello, World");	
//		ctv.caption = true;				    // 캡션기능을 켠다.
		ctv.setCaption(true);
		ctv.displayCaption("Hello, World");	// 캡션을 화면에 보여 준다.
	}
}
