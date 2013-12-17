package com.journaldev.enums;

public class ThreadTest {

		public static void main(String[] args) {
			System.out.println("Main="+Thread.currentThread().getName());
			MyThread th = new MyThread();
			
			for(int i=0; i<10; i++){
				Thread t = new Thread(th);
				t.start();
			}
			
			Thread tt = new Thread(th);
			tt.setName("Testing thread");
			tt.start();
	}

}
