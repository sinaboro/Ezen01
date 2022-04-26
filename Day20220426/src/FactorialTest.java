
public class FactorialTest {
	public static void main(String args[]) {
	
		System.out.println( factorial(4) ); // FactorialTest.factorial(4)
	}

	static long factorial(int n) {  //n = 1
		
		if (n == 1)
			return 1;

		return n * factorial(n - 1); // 메서드 자신을 호출한다.
		//     4 *  factorial(3)
		//            3 * factorial(2)
		//                   2 * factorial(1)  
		//                            1 
	}
}

// !4 = > 4*3*2*1 >>  48 