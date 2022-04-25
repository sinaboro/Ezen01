
public class BankAccount {  //클래스 --> 클래스 설계는 추상화개념
	
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

class MainClass{
	public static void main(String[] args) {
		
		//아래 화면 처럼 출력하기 위한 문장을 기술
		//System.out.println(); --> 문장 사용 금지
		BankAccount kim = new BankAccount(); //생성자호출 --> 현재는 디폴트 생성자호출됨 //계좌 개설
		kim.deposit(10000);
		kim.checkBanance();
		kim.withdraw(3000);
		kim.checkBanance();
		System.out.println("----------------------");
		//park
		BankAccount park = new BankAccount();//계좌 개설
		park.deposit(50000);
		park.checkBanance();
		park.withdraw(35000);
		park.checkBanance();
		System.out.println("----------------------");
				
		//Lee
		
		BankAccount lee = new BankAccount(); //계좌 개설
		lee.checkBanance();
		lee.deposit(15000);
		lee.checkBanance();
		lee.withdraw(5000);
		lee.checkBanance();
		System.out.println("----------------------");
		
		System.out.println("----------------------");
		
		lee = kim;
		lee.checkBanance(); //7000
		lee.deposit(10000);		
		kim.checkBanance(); //17000
		park.checkBanance(); //15000
		
	}
}
//잔액 : 10000
//잔액 : 7000