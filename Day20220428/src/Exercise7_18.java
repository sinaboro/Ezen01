class Exercise7_18 {
	
	static void action(Robot robot ) {
	
		if(robot instanceof DanceRobot) {
			DanceRobot dance = (DanceRobot)robot;
			dance.dance();
		}else if(robot instanceof SingRobot) {
			SingRobot sing = (SingRobot)robot;
			sing.sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot draw = (DrawRobot)robot;
			draw.draw();
		}
	}

	public static void main(String[] args) {
		
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		
		for (int i = 0; i < arr.length; i++)
			action(arr[i]);
	} // main
}

class Robot {
}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}