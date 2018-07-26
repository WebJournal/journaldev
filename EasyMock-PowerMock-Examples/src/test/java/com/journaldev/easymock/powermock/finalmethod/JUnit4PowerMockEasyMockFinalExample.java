package com.journaldev.easymock.powermock.finalmethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.easymock.PowerMock.*;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Data.class)
public class JUnit4PowerMockEasyMockFinalExample {

	@Test
	public void test_final_method_class() {
		//PowerMock.createMock()
		Data mock = createMock(Data.class);
		
		expect(mock.reverse("CAT")).andReturn("TAC");
		expect(mock.reverse(anyString())).andReturn("INVALID");
		
		//PowerMock.replay()
		replay(mock);
		
		assertEquals("TAC", mock.reverse("CAT"));
		assertEquals("INVALID", mock.reverse("Java"));
		
		//PowerMock.verify()
		verify(mock);
	}

}

final class Data {
	final String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}
}