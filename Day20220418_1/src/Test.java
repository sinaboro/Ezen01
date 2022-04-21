
public class Test {

	public static void main(String[] args) {
		int mul = 0;
		
		for(int i=1; i<3; i++) { //i=1
			for(int j=1; j<3; j++) {  //j=1
				mul = i * j;
				System.out.printf("%d ", mul);
			}
			System.out.println();
		}
	}

}
