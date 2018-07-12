package com.journaldev.mockito.stubbingconsecutivecalls;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class MockitoConsecutiveCallsStubbingExample {

	@Test
	void test() {
		UpdateUtils mockUU = mock(UpdateUtils.class);
		
		when(mockUU.update("Data"))
			.thenThrow(new RuntimeException())
			.thenReturn("DATA");
		
		when(mockUU.update("Emp")).thenReturn("EMP", "EMPLOYEE", "EMP1");
		
		assertThrows(RuntimeException.class, () -> mockUU.update("Data"));
		assertEquals("DATA", mockUU.update("Data"));
		//further calls will return the last mocked output
		assertEquals("DATA", mockUU.update("Data"));
		
		assertEquals("EMP", mockUU.update("Emp"));
		assertEquals("EMPLOYEE", mockUU.update("Emp"));
		assertEquals("EMP1", mockUU.update("Emp"));
		assertEquals("EMP1", mockUU.update("Emp"));
	}

}

class UpdateUtils {
	
	public String update(String msg) {
		return msg.toUpperCase();
	}
}