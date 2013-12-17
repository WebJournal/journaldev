package com.journaldev.exceptions;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public class TestException4 {

	public void start() throws IOException{		
	}
	
	public void foo() throws NullPointerException{
		
	}
}

class TestException5 extends TestException4{
	
	@Override
	public void start(){
	}
	
	public void foo() throws RuntimeException{
		
	}
}
