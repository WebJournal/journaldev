package com.journaldev.easymock;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.journaldev.utils.StringUtils;

public class EasyMockVoidMethodExample {

	@Test
	public void test() {
		StringUtils mock = mock(StringUtils.class);
		
		mock.print(anyString());
		expectLastCall().andAnswer(() -> {
			System.out.println("Mock Argument = "+getCurrentArguments()[0]);
			return null;
		});
		replay(mock);
		
		mock.print("Java");
		verify(mock);
	}
}
