
public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();

		if (f instanceof Unit) { //참조변수 f가 Unit를 참조하거나 Unit를 상속하는 클래스를 참조하면 OK
			System.out.println("f는 Unit클래스의 자손입니다.");
		}
		if (f instanceof Fightable) {
			System.out.println("f는 Fightable인터페이스를 구현했습니다.");
		}
		if (f instanceof Movable) {
			System.out.println("f는 Movable인터페이스를 구현했습니다.");
		}
		if (f instanceof Attackable) {
			System.out.println("f는 Attackable인터페이스를 구현했습니다.");
		}
		if (f instanceof Object) {
			System.out.println("f는 Object클래스의 자손입니다.");
		}
	}

}
