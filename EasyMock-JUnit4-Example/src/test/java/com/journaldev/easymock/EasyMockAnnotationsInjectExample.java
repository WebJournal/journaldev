package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import com.journaldev.utils.IntegerUtils;
import com.journaldev.utils.MyUtils;
import com.journaldev.utils.StringUtils;

public class EasyMockAnnotationsInjectExample {

	@Mock
	StringUtils su;
	@Mock
	IntegerUtils iu;

	@TestSubject
	MyUtils mu = new MyUtils(su, iu);

	@Before
	public void setup() {
		EasyMockSupport.injectMocks(this);
	}
	
	@Test
	public void test() {
		expect(iu.add(10, 10)).andReturn(20);
		expect(su.convert(10)).andReturn("10");
		expect(su.reverse("CAT")).andReturn("TAC");

		replay(su, iu);

		assertEquals(20, mu.add(10, 10));
		assertEquals("10", mu.convert(10));
		assertEquals("TAC", mu.reverse("CAT"));
	}

}
