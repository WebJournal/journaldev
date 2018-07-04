package com.journaldev.mockito.voidmethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.journaldev.Employee;

class JUnitMockitoVoidMethod {

	@Test
	void test_mockito_void() {
		Employee emp = mock(Employee.class);

		doThrow(IllegalArgumentException.class).when(emp).setName(null);

		doAnswer((i) -> {
			System.out.println("Employee setName Argument = " + i.getArgument(0));
			assertTrue("Pankaj".equals(i.getArgument(0)));
			return null;
		}).when(emp).setName(anyString());

		when(emp.getName()).thenReturn("Pankaj");

		assertThrows(IllegalArgumentException.class, () -> emp.setName(null));

		emp.setName("Pankaj");
		assertEquals("Pankaj", emp.getName());
	}

}
