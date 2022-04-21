import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
	
		// int[] nArr = new int[10] ; ==> 난수 (1~10)를 배열 입력
		//단, 중복된 숫자가 없어야 한다.
		
		Random rand = new Random(7);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열 갯수 입력 : ");
		int n = sc.nextInt();
		int[] nArr = new int[n];
		
		nArr[0] = rand.nextInt(10);
		
		for(int i=0; i<nArr.length; i++) {
			int j;
			do {
				j=0;
				nArr[i] = rand.nextInt(10) + 1;
				
				for(; j<i; j++)
					if(nArr[j] == nArr[i])
						break;
			}while(j<i);
		}
		
		System.out.println(Arrays.toString(nArr));
	}

}
