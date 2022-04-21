import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
	
		// int[] nArr = new int[10] ; ==> 난수 (0~9)를 배열 입력
		//단, 붙어있는 아이는 중복되면 안된다.  0 5 7 9 8 
		
		Random rand = new Random(7);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열 갯수 입력 : ");
		int n = sc.nextInt();
		int[] nArr = new int[n];
		
		nArr[0] = rand.nextInt(10);
		
		for(int i=1; i<nArr.length; i++) {
			do {
				nArr[i] = rand.nextInt(10);
			}while(nArr[i] ==nArr[i-1]);
		}
		
		System.out.println(Arrays.toString(nArr));
		
		
	}

}
