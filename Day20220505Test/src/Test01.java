
public class Test01 {

	public static void main(String[] args) {
		
		//반환형 없는 경우, 매개전달 없는 경우
		sum();

		//반환형 없는 경우, 매개전달 있는 경우
		sum2(10,20);

		//반환형 있는 경우, 매개전달 있는 경우
		int num = sum3(10,20);
		System.out.println(num);

		//반환형 있는 경우, 매개전달 없는 경우
		int num2 = sum4();
		System.out.println(num2);

	}
	
	//    반환   이름(매개변수)  
	static void sum() {
		System.out.println("sum");
	}
	static void sum2(int i, int j) {
		System.out.println(i+j);
	}
	static int sum3(int i, int j) {
		return i+j;
	}

	static int sum4() {
		return 100;
	}

}


class Time{
	int hour=500;
	int minute;
	int second;
	
	static int  num=100;
}