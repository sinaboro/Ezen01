
public class BankAccount2 {  //클래스 --> 클래스 설계는 추상화개념
	
	private int balance;  //잔액 멤버변수, 인스턴스변수 , 원칙 : 변수는 외부에서 직접 접근을 금지 ,정보은닉 목적 중 무결성
	
	int deposit(int amount) {  //입금
		
		if(amount<0)
			return 0;
		balance += amount;
		
		return balance;
	}
	
	int withdraw(int amount) {//출금
		balance -= amount;
		return balance;
	}
	void checkBanance() {  //잔고 확인
		System.out.println("잔액 : " + balance);
	}
}

class MainClass2{
	public static void main(String[] args) {
	
		BankAccount2[] bank = new BankAccount2[3];
		
		bank[0] = new BankAccount2();
		bank[1] = new BankAccount2();
		bank[2] = new BankAccount2();
		
		bank[0].deposit(10000);
		bank[0].withdraw(3000);
		
		bank[0].checkBanance();
	}
}
//잔액 : 10000
//잔액 : 7000