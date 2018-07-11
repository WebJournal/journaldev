package com.journaldev.mockito.staticmethod;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.internal.verification.AtLeast;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.Test;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class JUnit4PowerMockitoStaticTest{

	@Test
	public void test_static_mock_methods() {
		PowerMockito.mockStatic(Utils.class);
		when(Utils.print("Hello")).thenReturn(true);
		when(Utils.print("Wrong Message")).thenReturn(false);
		
		assertTrue(Utils.print("Hello"));
		assertFalse(Utils.print("Wrong Message"));
		
		PowerMockito.verifyStatic(Utils.class, atLeast(2));
		Utils.print(anyString());
	}
}
