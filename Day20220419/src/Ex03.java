import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		int fee = 2500;
		
		int age=0;
		double rate =0.0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이 입력(0~100세 정수 입력) >> ");
		
		age = sc.nextInt();  
		
		 if(age>=65)
			 rate = 0;
		 else if(age>=20)
			 rate = 1;
		 else if(age>=14)
			 rate = 0.75;
		 else if(age>=4)
			 rate = 0.5;
		 else if(age<4)
			 rate = 0;
		 else
			 System.out.println("정확한 값 입력 요망!!!");
		 
		 System.out.println((int)(fee*rate) + "원");
	}

}
