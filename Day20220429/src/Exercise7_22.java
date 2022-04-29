abstract class Shape{
	Point p;
	
	public Shape() {
		this(new Point(0,0));
	}
	
	public Shape(Point p) {
		this.p = p;
	}
	
	abstract double cacleArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPoistion(Point p) {
		this.p = p;
	}
}

class Circle extends Shape{
	double r;
	
	public Circle() {}
	
	//new Circle(5);
	public Circle(double r) {
		this.r  = r;
	}
	
	//Shape s2 = new Circle(new Point(10,10), 5);
	public Circle(Point p, double r) {
		super(p);
		this.r = r;
	}
	
	@Override
	double cacleArea() {
		return Math.PI * r * r;
	}
}

class Rectangle extends Shape{
	double width;
	double height;
	
	public Rectangle() {
		this(new Point(0,0),0,0);
	}
	//Shape r2 = new Rectangle(150,50);
	public Rectangle(double width, double height) {
//		this.width = width;
//		this.height = height;
		this(new Point(0,0),width,height);
	}
	//Shape r3 = new Rectangle(new Point(100,100), 150,50);
	public Rectangle(Point p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}
	
	@Override
	double cacleArea() {
		return width * height;
	}
	
	boolean isSquare() {
	//	if( width == height && width != 0 && height !=0 )
		if( width == height && width*height !=0 )
			return true;
		else
			return false;
	}
}

class Point{
	int x,y;
	Point() { this(0,0); }
	Point(int x,int y){ this.x = x; this.y = y; }
}

public class Exercise7_22 {

	public static void main(String[] args) {
		Shape s = new Circle();
		Shape s2 = new Circle(new Point(10,10), 5);
		Shape s3 = new Circle(5);
		System.out.println(s2.cacleArea());
		
		Shape r = new Rectangle();
		Shape r2 = new Rectangle(150,50);
		Shape r3 = new Rectangle(new Point(100,100), 150,50);
		System.out.println(r3.cacleArea());
		
	}

}
