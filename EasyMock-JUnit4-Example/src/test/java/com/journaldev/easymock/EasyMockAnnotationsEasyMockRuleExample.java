package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.journaldev.utils.IntegerUtils;
import com.journaldev.utils.MyUtils;
import com.journaldev.utils.StringUtils;

public class EasyMockAnnotationsEasyMockRuleExample {

	@Mock
	StringUtils su;
	@Mock
	IntegerUtils iu;

	@TestSubject
	MyUtils mu = new MyUtils(su, iu);

	@Rule
	public EasyMockRule easyMockRule = new EasyMockRule(this);

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
