package com.journaldev.enums;

public class Test {

	public static void main(String[] args) {
		try {
			someMethod(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void someMethod(int i) throws Exception {
		ThreadStatesEnum th = null;
		
		switch(i){
		case 1:
			th = ThreadStatesEnum.START;
			break;
		case 2:
			th = ThreadStatesEnum.RUNNING;
			break;
		case 3:
			th = ThreadStatesEnum.WAITING;
			break;
		case 4:
			th = ThreadStatesEnum.DEAD;
			break;
		}
		
		if(th == null)
			throw new Exception("invalid argument");
		
		//now we can use th in switch statements
	}
}
