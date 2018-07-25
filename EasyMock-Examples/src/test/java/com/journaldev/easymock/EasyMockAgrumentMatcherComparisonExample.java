package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EasyMockAgrumentMatcherComparisonExample {

	@Test
	public void test() {
		List<Integer> mock = mock(ArrayList.class);
		
		expect(mock.add(lt(10))).andReturn(true);
		expect(mock.add(geq(10))).andReturn(false);
		replay(mock);
		
		assertTrue(mock.add(5));
		assertFalse(mock.add(100));

	}
}