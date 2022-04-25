
public class TestVariables {

	public static void main(String[] args) {
		
		Variables  var = new Variables();
		var.iv++;
		
		var.cv++;  //클래스 변수
		
		System.out.println("var : " + var.iv);
		System.out.println("var_cv : " + var.cv);

		
		Variables var2 = new Variables();
		var2.iv++;
		
		Variables.cv++;
		
		System.out.println("var2 : " + var2.iv);  // 1 or  2
		System.out.println("var2_cv : " + var2.cv);  // 1 or  2

		Variables var3 = new Variables();
		var3.iv++;
		
		Variables.cv++;
		
		System.out.println("var3 : " + var3.iv);  // 1 or  2
		System.out.println("var3_cv : " + var3.cv);  // 1 or  2
		
		System.out.println("------------");
		
		Variables var4 = new Variables();
		System.out.println(var4.iv);  // 인스턴스 변수는 객체 생성후 사용해야한다.
		
		
	}

}


class Variables{
	int iv;  //인스턴스변수 ,멤버변수
 
	static int cv;  //클래스변수, 정적변수, 공유변수
    
    void method() {
    	int lv=0;   //지역변수
    }
}