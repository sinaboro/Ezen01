package LGSaumsung;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTv();
		}else if(beanName.equals("lgtv")) {
			return new LgTv();
		}
		return null;
	}
}
