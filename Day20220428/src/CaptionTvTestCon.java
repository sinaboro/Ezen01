class Tv3 {
	private boolean power; 	// 전원상태(on/off)
	private int channel;	// 채널

	public Tv3() {}
	
	public Tv3(int channel) {
		this.channel = channel;
	}
	
	public Tv3(boolean power, int channel) {
		this.power = power;
		this.channel = channel;
	}
	
	int getChannel() {
		return channel;
	}
	
	boolean getPower() {
		return power;
	}
	
	void power()        {   power = !power; }
	void channelUp()    { 	 ++channel;     }
	void channelDown()  {	 --channel;	    }
}

class CaptionTv3 extends Tv3 {
	private boolean caption;		// 캡션상태(on/off)
	
	public CaptionTv3() {}
	
	public CaptionTv3(int channel, boolean caption) {
		super(channel);
		this.caption = caption;
	}
	public CaptionTv3(boolean power,int channel, boolean caption ) {
		super(power ,channel);
		this.caption = caption;
	}
	
	void displayCaption(String text) {
		if (caption) {	// 캡션 상태가 on(true)일 때만 text를 보여 준다.
			System.out.println(text);
		}
	}
}

class CaptionTvTestCon {
	public static void main(String args[]) {
		CaptionTv3 ctv = new CaptionTv3(10,true);
	//	ctv.channel = 10;				// 조상 클래스로부터 상속받은 멤버
	//	ctv.caption = true;				    // 캡션기능을 켠다.
		
		ctv.channelUp();				// 조상 클래스로부터 상속받은 멤버
//		System.out.println(ctv.channel);
		System.out.println(ctv.getChannel());
		ctv.displayCaption("Hello, World");	
		ctv.displayCaption("Hello, World");	// 캡션을 화면에 보여 준다.
	}
}
