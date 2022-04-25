
public class Tv {
	
	   //변수 == 인스턴스변수
		String color;
		boolean power;  //인스턴스 변수
		int channel;  //채널 번호 저장
		
		//메소드 == 인스턴스메소드
		void power() {
			power = !power;
		}
		
		void channelUp() {
			++channel;
		}
		
		void channelDown() {
			--channel;
		}
}

  class TvTest{
	  
	public static void main(String[] args) {
		// tv객체를 만들고 싶다.  ++++> 객체를 만들려면 클래스(설계도)가 있어야한다.
		
		Tv t  = new Tv();
		
		t.channel = 7;
		t.channelDown();
		System.out.println("t : " + t.channel);
		
		Tv t2 = new Tv();
		t2.channel = 10;
		t2.channelUp();
		System.out.println("t2 : " + t2.channel);
		
		Tv t3 = t2;
		System.out.println("t3 : " + t3.channel);
		
		int num = 10;
	}
}
