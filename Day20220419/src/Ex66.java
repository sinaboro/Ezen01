import java.util.Scanner;

public class Ex66 {
	public static void main(String[] args) {

		int fee = 2500;
		int age = input();
		double rate = feeCalcRate(age);
		output(age, fee, rate);
	}
	
	static int input() { //입력
		int age=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("나이 입력(0~100세 정수 입력) >> ");
		age = sc.nextInt();  
		return age;
	}
	
	static double feeCalcRate(int age) { //할인율 계산
		double rate = 0.0;
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
		 return rate;
	}
	
	static void output(int age,int fee, double rate) {  //출력
		System.out.println(age + "세 요금은 " + (int)(fee*rate) + "원"); 
	}
}
