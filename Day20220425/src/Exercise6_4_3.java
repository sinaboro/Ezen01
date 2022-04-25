
public class Exercise6_4_3 {

	public static void main(String[] args) {
	
		Student3 s = new Student3("홍길동",1,1,100,60,76);  //생성자
		
		//s.setName("홍길동");
	//	s.name = "홍길동";
	//	s.setBan(1);
	//	s.ban = 1;
	//	s.setNo(1);
	//	s.no = 1;
	//	s.setKor(100);
	//	s.kor = 100;
	//	s.setEng(60);
	//	s.eng = 60;
	//	s.setMath(76);
	//	s.math = 76;
		
		
		System.out.println("이름:" + s.getName() );
		System.out.println("총점:" + s.getTotal() );
		System.out.println("평균:" + s.getAverage() );
	}
}

class Student3{
	
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
	public String getName() {
		return name;
	}
	public Student3(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal(){
		return kor+eng+math;
	}
	
	double getAverage(){
		//return getTotal()/3.0;
		return (int)((getTotal()/3.0+0.05)*10)/10.0;
	}
	
}