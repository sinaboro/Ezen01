import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		// 세 정수를 입력받아서 최대,중간, 최소값 출력
		Scanner sc = new Scanner(System.in);

		int num1, num2, num3;
		int max, min, med;
		max=min=med=0;

		System.out.println("정수 3개 입력 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();

		if (num2 > num1) {  // && ||
			if (num2 > num3) {
				max = num2;
				if (num1 > num3) {
					med = num1;
					min = num3;
				}
				else {
					med = num3;
					min = num1;
				}
			}
			else {
				max = num3;
				med = num2;
				min = num1;
			}
		} else if (num3 > num1) {
			max = num3;
			med = num1;
			min = num2;
		}else {
			if(num2> num3) {
				max = num1;
				med = num2;
				min = num3;
			}else {
				max = num1;
				med = num3;
				min = num2;
			}
		}
		System.out.printf("max:%d, med:%d, min:%d\n",max,med,min);
		System.out.println("-----------------------------------");
		
		if(num1>num2)
			if(num2 > num3) {
				max = num1;
				med = num2;
				min = num3;
			}else if( num1 > num3) {
				max = num1;
				med = num3;
				min = num2;
			}else {
				max = num3;
				med = num2;
				min = num1;
			}
			
				
	}

}
