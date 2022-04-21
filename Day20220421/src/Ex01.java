import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		//세 정수를 입력받아서 최대값 출력( 배열X) >> 조건문 사용
		Scanner sc = new Scanner(System.in);
		
		int num1,num2,num3, max;
		
		System.out.println("정수 3개 입력 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		max = num1;  
		if(num2 > max) {
			if(num2 > num3)
				max = num2;
			else
				max = num3;
		}
		else if(num3 > max)
			max = num3;
		System.out.println("max : " + max);
			
	    System.out.println("------------------------");
	    //세 정수를 큰 순서 대로 출력
		
	}

}
