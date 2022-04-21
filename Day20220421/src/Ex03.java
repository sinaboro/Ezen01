import java.util.Scanner;

public class Ex03 {

	static int num1, num2, num3; // 정적변수 , 클래스 변수 >> class안에서 공용으로 사용

	public static void main(String[] args) {

		// 세 정수를 입력받아서 최대값 출력( 배열X) >> 조건문 사용

		input();
		int max = calu();
		output(max);
	}

	static void input() {
		Scanner sc = new Scanner(System.in); // input
		System.out.println("정수 3개 입력 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
	}

	static int calu() {
		
		int max = num1;
		if (num2 > max) { // Calu
			if (num2 > num3)
				max = num2;
			else
				max = num3;
		} else if (num3 > max)
			max = num3;
		return max;
	}
	
	static void output(int num) {
		System.out.println("max : " + num);
	}

}
