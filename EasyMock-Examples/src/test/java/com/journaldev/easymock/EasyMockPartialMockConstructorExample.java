package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Base64;

import org.junit.jupiter.api.Test;

public class EasyMockPartialMockConstructorExample {

	@Test
	public void test() {
		Data mock = partialMockBuilder(Data.class)
					.withConstructor(String.class)
					.withArgs("Hello")
					.addMockedMethods("decode")
					.createMock();
		//calling real methods
		mock.print();
		String encodedMessage = mock.encode();
		System.out.println(encodedMessage);
		assertEquals(Base64.getEncoder().encodeToString("Hello".getBytes()), mock.encode());
		
		//mock some behaviors
		expect(mock.decode()).andReturn("Hello");
		replay(mock);
		assertEquals("Hello", mock.decode());
		
		verify(mock);
	}
}

class Data {
	private String message;
	private String encodedMsg;
	
	public Data(String msg) {
		this.message = msg;
	}
	public void print() {
		System.out.println("Message is: "+this.message);
	}
	public String encode() {
		this.encodedMsg = Base64.getEncoder().encodeToString(this.message.getBytes());
		return encodedMsg;
	}
	public String decode() {
		return String.valueOf(Base64.getDecoder().decode(encodedMsg));
	}
}