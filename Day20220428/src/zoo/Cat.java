package zoo;

// public >> protected >> default >> private

public class Cat {
	protected  void makeCat() {
	}
	public void run() {}
}

class Duck {  
	public void func() {
		System.out.println("test");
	}
}
