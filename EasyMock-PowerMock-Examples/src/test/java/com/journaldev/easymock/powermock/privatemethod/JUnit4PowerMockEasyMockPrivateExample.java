package com.journaldev.easymock.powermock.privatemethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Foo.class)
public class JUnit4PowerMockEasyMockPrivateExample {

	@Test
	public void test_private_method() throws Exception {
		Foo mock = createPartialMock(Foo.class, "isInit", "reverse");
		
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

class Foo {
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