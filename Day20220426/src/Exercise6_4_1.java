import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class Exercise6_4_1 {

	public static void main(String[] args) {
		
		Student2 s = new Student2("손흥민", 1, 10, 90, 100, 60 );  //생성자 호출 >> 디폴트생성자
		System.out.println(s.getName());
		System.out.println(s.getTotal());

		Student2 s2 = new Student2("이상우", 2, 9, 90, 80, 70 );  //생성자 호출 >> 디폴트생성자
		System.out.println(s2.getName());
		System.out.println(s2.getTotal());

		Student2 s3 = new Student2("박상무", 2, 9);  //생성자 호출 >> 디폴트생성자
		System.out.println(s3.getName());
		System.out.println(s3.getTotal());
		
		Student2 s4 = new Student2();
		System.out.println(s4.getTotal());
		
	}
}

// private < default < protected < public

@Getter  //어노테이션
@Setter
@ToString
class Student2{
		
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
	public Student2() {} //디폴트 생성자는 생성자가 존재하지않으면 java컴파일러가 생성해주지만, 생성자가 1개라도 존재하면
		                //생성하지 않는다. 필요하면 개발자가 직접 작성
		
	//함수 오버로딩
	public Student2(String name, int ban, int no, int kor,int eng, int math) {
		this.name= name;
		this.ban  = ban;
		this.no  = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public Student2(String name, int ban, int no) {
		this.name = name;
		this.ban  = ban;
		this.no  = no;
	}
	
	int getTotal() {
		int sum = kor+eng+math;
		return sum;
	}
	
	double getAverage() {
		return getTotal()/3.0;
	}
}
