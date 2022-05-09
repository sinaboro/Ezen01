package com.ezen01;

public class Thread01 {

	public static void main(String[] args) {
//		Thread ct = Thread.currentThread();
//		String name = ct.getName();
//		System.out.println(name);
		System.out.println("-----------------------");
		//람다식
//		Runnable task = ()->{
//			int n1 = 10;
//			int n2 = 20;
//			String name = Thread.currentThread().getName();
//			System.out.println(name + "," + (n1+n2));
//		};
//		
//		Thread t = new Thread(task);
//		t.start();
//		System.out.println("end : " + Thread.currentThread().getName() );
		System.out.println("-----------------------");
		
		Runnable task1 = () ->{
			for(int i=0; i<20; i++) {
				if( i %2 ==0)
					System.out.print(i + " ");
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable task2 = () ->{
			for(int i=0; i<20; i++) {
				if( i %2 == 1)
					System.out.print(i + " ");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread r1 = new Thread(task1);	
		Thread r2 = new Thread(task2);	
		r1.start();
		r2.start();
		
	}

}
