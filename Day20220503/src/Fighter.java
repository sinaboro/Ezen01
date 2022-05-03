class Fighter extends Unit implements Fightable {
	public void move(int x, int y) { /* 내용 생략 */ }
	public void attack(Unit u) { /* 내용 생략 */ }
}

class Unit {
	int currentHP;	// 유닛의 체력
	int x;			// 유닛의 위치(x좌표)
	int y;			// 유닛의 위치(y좌표)
}

interface Fightable extends Movable, Attackable { }
interface Movable {	void move(int x, int y);	}
interface Attackable {	void attack(Unit u); }
