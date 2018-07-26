package com.journaldev.easymock.powermock.staticmethod;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class JUnit4PowerMockEasyMockStaticExample {

	@Test
	public void test_static_method() {
		//PowerMock.mockStatic()
		mockStatic(Utils.class);
		
		expect(Utils.generateID()).andReturn(1000L);
		
		//PowerMock.replayAll()
		replayAll();
		
		assertEquals(1000L, Utils.generateID());
		//PowerMock.verifyAll()
		verifyAll();
	}
}
class Utils {

	public static long generateID() {
		return System.currentTimeMillis();
	}
}