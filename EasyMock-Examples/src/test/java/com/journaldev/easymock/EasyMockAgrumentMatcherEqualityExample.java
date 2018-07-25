package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class EasyMockAgrumentMatcherEqualityExample {

	@Test
	public void test() {
		Utils mock = mock(Utils.class);
		Object obj = new Object();
		
		expect(mock.convert(same(obj))).andReturn("True");
		expect(mock.convert(eq("ABC"))).andReturn("Awesome");

		expect(mock.convert(anyObject())).andReturn("False");
		replay(mock);
		
		assertEquals("True", mock.convert(obj));
		assertEquals("Awesome", mock.convert("ABC"));

		assertEquals("False", mock.convert(new Object()));
	}
}

class Utils {
	public String convert(Object obj) {
		return obj.toString();
	}
}