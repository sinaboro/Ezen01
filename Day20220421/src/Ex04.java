import java.util.Scanner;

public class Ex04 {
	
	public static void main(String[] args) {
	
		//두 배열 요소가 같으면 true, 틀리면 false
		int[] nArr1 = {1,10,20,30,40,50};
		int[] nArr2 = {1,10,25,30,40,50};
		
		boolean check = ArrayEqual(nArr1,nArr2);
		
		System.out.print("nArr1 :  ");
		for(int i: nArr1)
			System.out.print(i+ " ");
		
		System.out.println();
		
		System.out.print("nArr2 :  ");
		for(int i: nArr2)
			System.out.print(i+ " ");
		
		System.out.println("\n두 요소는 " + check);
	
	}
	
	//두 배열 비교는 여기서
	static boolean ArrayEqual(int[] n1, int[] n2) {
		
		if(n1.length != n2.length) //길이가 차이가 있다면 false
			return false;
		
		for(int i=0; i<n1.length; i++)
			if(n1[i] != n2[i]) 
				return false;
		
		return true;
		
	}
}
