package LGSaumsung;

public class TvUser {

	public static void main(String[] args) {
		TV tv = new LgTv();
		tv.PowerOn();
		tv.PowerDown();
		tv.volumeUp();
		tv.volumeDown();
		
//		BeanFactory factory  = new BeanFactory();
//		TV tv = (TV)factory.getBean(args[1]);
//		tv.PowerOn();
//		tv.PowerDown();
//		tv.volumeUp();
//		tv.volumeDown();
	}

}
