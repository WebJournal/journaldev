package com.journaldev.easymock.powermock.privatemethod;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.powermock.api.easymock.PowerMock.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@PrepareForTest(Foo1.class)
public class TestNGPowerMockEasyMockPrivateExample extends PowerMockTestCase{

	@Test
	public void test_private_method() throws Exception {
		Foo1 mock = createPartialMock(Foo1.class, "isInit", "reverse");
		
		expectPrivate(mock, "isInit").andReturn(true);
		expectPrivate(mock, "reverse", "cat").andReturn("tac");
		expectPrivate(mock, "reverse", "123").andReturn("321");
		replay(mock);
		
		assertTrue(mock.checkStatus());
		assertEquals("tac", mock.doReverse("cat"));
		assertEquals("321", mock.doReverse("123"));
		
		verify(mock);
	}
}

class Foo1 {
	private boolean isInit() {
		return false;
	}
	private String reverse(String s) {
		//return new StringBuilder(s).reverse().toString();
		return null;
	}
	public boolean checkStatus() {
		return isInit();
	}
	public String doReverse(String s) {
		return reverse(s);
	}
}