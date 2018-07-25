package com.journaldev.easymock;

import static org.easymock.EasyMock.*;

import org.junit.jupiter.api.Test;

import com.journaldev.utils.StringUtils;

public class EasyMockVoidMethodExample {

	@Test
	public void test() {
		StringUtils mock = mock(StringUtils.class);
		
		mock.print(anyString());
		expectLastCall().andAnswer(() -> {
			System.out.println("Mock Argument = "
					+getCurrentArguments()[0]);
			return null;
		}).times(2);
		
		//mock void method without any logic
		//expectLastCall().andVoid().times(2);
		
		replay(mock);
		
		mock.print("Java");
		mock.print("Python");
		verify(mock);
	}
}
