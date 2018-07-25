package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EasyMockAgrumentMatcherConditionalExample {

	@Test
	public void test() {
		List<Integer> mock = mock(ArrayList.class);
		
		//return true if number is between 0 to 10
		expect(mock.add(and(gt(0), lt(10)))).andReturn(true);
		
		//return true if number is 33 or 77
		expect(mock.add(or(eq(33), eq(77)))).andReturn(true);
		
		//return true if number is not 99
		expect(mock.add(not(lt(100)))).andReturn(false);		
				
		replay(mock);
		
		assertTrue(mock.add(5));
		assertTrue(mock.add(33));
		assertFalse(mock.add(102));
	}
}