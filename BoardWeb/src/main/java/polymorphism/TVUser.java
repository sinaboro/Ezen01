package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		 TV tv1 = (TV) factory.getBean("samsungTV");
		tv1.powerOn();
//		tv1.volumeUp();
//		tv1.volumeDown();
//		tv1.powerOff();
		
		factory.close();
	}
}
