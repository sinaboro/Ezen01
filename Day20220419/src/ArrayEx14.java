import java.util.Arrays;

public class ArrayEx14 {

	public static void main(String[] args) {
		
		String src = "ABCDE";
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i); // src의 i번째 문자를 ch에 저장
			//char ch = 'B'; // i=1
			System.out.println("src.charAt(" + i + "):" + ch);
		}
        
		int[] num = {1,2,3};
		
		char[] chArr = src.toCharArray(); // String을 char[]로 변환

		System.out.println(chArr); // char배열(char[])을 출력

		String msg = "korea";
		chArr = msg.toCharArray();
		System.out.println(chArr); // char배열(char[])을 출력
		System.out.println(Arrays.toString(num));
	}
}
