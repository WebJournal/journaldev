package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.journaldev.utils.IntegerUtils;
import com.journaldev.utils.MyUtils;
import com.journaldev.utils.StringUtils;

@RunWith(EasyMockRunner.class)
public class EasyMockAnnotationsRunWithExample {

	@Mock StringUtils mockSU;
	@Mock IntegerUtils mockIU;

	@TestSubject MyUtils mu = new MyUtils(mockSU, mockIU);

	@Test
	public void test() {
		expect(mockIU.add(10, 10)).andReturn(20);
		expect(mockSU.convert(10)).andReturn("10");
		expect(mockSU.reverse("CAT")).andReturn("TAC");

		replay(mockSU, mockIU);

		assertEquals(20, mu.add(10, 10));
		assertEquals("10", mu.convert(10));
		assertEquals("TAC", mu.reverse("CAT"));
	}

}
