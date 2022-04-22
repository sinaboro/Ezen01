import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
	
		Scanner sc  =  new Scanner(System.in);
		
		int n = sc.nextInt()   ;
		int[] nArr = new int[n]   ;
		int j ;

		nArr[0] = (int)(Math.random()*10);

		for(int i = 1; i < nArr.length; i++) {  

		   nArr[i] = (int)(Math.random()*10);
		   
		  for(j = 0 ; j <i ; j++) {  
		      if(nArr[j]==nArr[i])
			  i--;
		       	//break;
		      
		     
		  } //for j

		} // for i
		System.out.println(Arrays.toString(nArr));
	}
}
