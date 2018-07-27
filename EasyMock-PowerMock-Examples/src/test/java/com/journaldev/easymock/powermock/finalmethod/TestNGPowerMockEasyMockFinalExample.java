package com.journaldev.easymock.powermock.finalmethod;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.powermock.api.easymock.PowerMock.*;
import static org.testng.Assert.assertEquals;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.anyString;

@PrepareForTest(Data1.class)
public class TestNGPowerMockEasyMockFinalExample extends PowerMockTestCase{

	@Test
	public void test_final_method_class() {
		//PowerMock.createMock()
		Data1 mock = createMock(Data1.class);
		
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

final class Data1 {
	final String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}
}