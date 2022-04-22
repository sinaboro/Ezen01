/*
 * 주사위 2개를 던진다.
 * (1,2)
 * (4,5)
 * (6,6)
 * (3,2) ==> break 두 수 합이 5가 되면 종료 
 */
public class DiceGame {
	public static void main(String[] args) {
		
		while(true) {
		    
			int num1 = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
				
			System.out.println("(" + num1 + "," + num2 + ")");
			
			if((num1+num2) == 5) break;
		}
	}

}


