package com.journaldev.easymock.powermock.staticmethod;

import static org.easymock.EasyMock.*;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.powermock.api.easymock.PowerMock.*;
import static org.testng.Assert.assertEquals;

@PrepareForTest(Utils1.class)
public class TestNGPowerMockEasyMockStaticExample extends PowerMockTestCase{

	@Test
	public void test_static_method() {
		//PowerMock.mockStatic()
		mockStatic(Utils1.class);
		
		expect(Utils1.generateID()).andReturn(1000L);
		
		//PowerMock.replayAll()
		replayAll();
		
		assertEquals(1000L, Utils1.generateID());
		//PowerMock.verifyAll()
		verifyAll();
	}
}
class Utils1 {

	public static long generateID() {
		return System.currentTimeMillis();
	}
}