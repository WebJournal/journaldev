package com.journaldev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit5Sample3Test {

	@Test
	void testAssumeTrue() {
	    boolean b = 'A' == 'A';
		assumeTrue(b);
	    assertEquals("Hello", "Hello");
	}
	
	@Test
	@DisplayName("test executes only on Saturday")
	public void testAssumeTrueSaturday() {
	  LocalDateTime dt = LocalDateTime.now();
	  assumeTrue(dt.getDayOfWeek().getValue() == 6);
	  System.out.println("further code will execute only if above assumption holds true");
	}
	
	@Test
	void testAssumeFalse() {
	    boolean b = 'A' != 'A';
		assumeFalse(b);
	    assertEquals("Hello", "Hello");
	}
	
	@Test
    void testAssumeFalseEnvProp() {
        System.setProperty("env", "prod");
        assumeFalse("dev".equals(System.getProperty("env")));
        System.out.println("further code will execute only if above assumption hold");
    }
	
	@Test
    void testAssumingThat() {
		 System.setProperty("env", "test");
        assumingThat("test".equals(System.getProperty("env")),
            () -> {
                assertEquals(10, 10);
                System.out.println("perform below assertions only on the test env");
            });

        assertEquals(20, 20);
        System.out.println("perform below assertions on all env");
    }
	
}
