
final class Singleton{
	private static Singleton s = new Singleton();
	private Singleton() {}
	
	public static Singleton getInstance() {
		System.out.println(s);
		if( s == null  ) {
			System.out.println("null");
			return new Singleton();
		}
		return s;
	}
}
public class SingletonTest {
	public static void main(String[] args) {
		Singleton ss = Singleton.getInstance();
		System.out.println(ss);
		
		Singleton  s2 = Singleton.getInstance();
		System.out.println(s2);
	}
}
