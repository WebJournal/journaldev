package com.journaldev.mockito.staticmethod;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

@PrepareForTest(Utils.class)
public class TestNGPowerMockitoStaticTest extends PowerMockTestCase{

	@Test
	public void test_static_mock_methods() {
		PowerMockito.mockStatic(Utils.class);
		when(Utils.print("Hello")).thenReturn(true);
		when(Utils.print("Wrong Message")).thenReturn(false);
		
		assertTrue(Utils.print("Hello"));
		assertFalse(Utils.print("Wrong Message"));
		
		PowerMockito.verifyStatic(Utils.class);
		Utils.print("Hello");
		PowerMockito.verifyStatic(Utils.class, times(2));
		Utils.print(anyString());
	}
}
