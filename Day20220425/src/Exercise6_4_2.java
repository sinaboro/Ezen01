
public class Exercise6_4_2 {

	public static void main(String[] args) {
	
		Student2 s = new Student2();
		
		s.setName("홍길동");
	//	s.name = "홍길동";
		s.setBan(1);
	//	s.ban = 1;
		s.setNo(1);
	//	s.no = 1;
		s.setKor(100);
	//	s.kor = 100;
		s.setEng(60);
	//	s.eng = 60;
		s.setMath(76);
	//	s.math = 76;
		
		System.out.println("이름:" + s.getName() );
		System.out.println("총점:" + s.getTotal() );
		System.out.println("평균:" + s.getAverage() );
	}
}

class Student2{
	
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
	public String  getName() {
		return  name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
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