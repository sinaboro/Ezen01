
// 클래스 4대 특성  >> 캡술화, 상속, 추상화, 다형성
public class Ex01 {

	public static void main(String[] args) {
		int i=0;
		while(i++<4) {
			int num = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*4)+1;
			
			System.out.println(num +  ", " +  num2);
		}
	}

}
