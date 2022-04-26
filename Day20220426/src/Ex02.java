
public class Ex02 {
   int iv;  //객체 생성해야 메모리 상주
   static int cv=0;  //고융변수, 객체전 메모리 공간 상주
   
   public static void main(String[] args) {
//	   System.out.println(iv);
//	   System.out.println(cv);
	   
	   int i=10;
	   
	   Ex02 e1 = new Ex02();
	   System.out.println(e1.iv);
	   System.out.println(e1.cv);
	   Ex02 e2 = new Ex02();
	   System.out.println(e2.iv);
	   System.out.println(e2.cv);
	   Ex02 e3 = new Ex02();
	   System.out.println(e3.iv);
	   System.out.println(e3.cv);
   }
   
   
   public Ex02() {
	   iv++;
	   cv++;
   }
   
   static void func() {
//	   System.out.println(iv);
	   System.out.println(cv);
   }
}
