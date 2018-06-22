package com.journaldev.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class AssertionsExample {

	@Test
	@DisplayName("This will Fail, don't worry!")
	void test_fail() {
		fail();
		fail("Not yet implemented");
		fail(() -> {
			return "Not yet implemented";
		});
		fail("Not Yet Implemented", new RuntimeException("Explicitly Failed"));
		fail(new RuntimeException("Explicitly Failed"));

	}

	@Test
	@DisplayName("assertNull Examples")
	void test_assertNull() {
		assertNull(null);
		// assertNull(new Object(), "assertNull Fail Message");
	}

	@Test
	@DisplayName("assertNotNull Examples")
	void test_assertNotNull() {
		assertNotNull(new Object());
		// assertNotNull(null, "assertNotNull Fail Message");
	}

	@Test
	@DisplayName("assertSame Examples")
	void test_assertSame() {
		assertSame("Hi", "Hi");
		// this will fail
		// assertSame("Hi", new String("Hi"), "My Failure Message");

	}

	@Test
	@DisplayName("assertNotSame Examples")
	void test_assertNotSame() {
		assertNotSame("Hi", "Hello");
		// this will fail
		// assertNotSame("Hi", "Hi", "assertNotSame Failure Message");

	}

	@Test
	@DisplayName("assertTrue Examples")
	void test_assertTrue() {
		assertTrue(3 > 0);
		assertTrue(() -> {
			return true;
		});

		assertTrue(3 > 0, "assertTrue fail message");
		assertTrue(3 > 0, () -> {
			return "assertTrue fail message";
		});

		assertTrue(() -> {
			return true;
		}, "assertTrue fail message");
		assertTrue(() -> {
			return true;
		}, () -> {
			return "assertTrue fail message";
		});
	}

	@Test
	@DisplayName("assertFalse Examples")
	void test_assertFalse() {
		assertFalse(3 < 0);
		assertFalse(() -> {
			return false;
		});

		assertFalse(3 < 0, "assertFalse fail message");
		assertFalse(3 < 0, () -> {
			return "assertFalse fail message";
		});

		assertFalse(() -> {
			return false;
		}, "assertFalse fail message");
		assertFalse(() -> {
			return false;
		}, () -> {
			return "assertFalse fail message";
		});
	}

	@Test
	@DisplayName("assertEquals Examples")
	void test_assertEquals() {
		assertEquals(10, 10);
		assertEquals(true, true, "assertEquals Failure Message");
		assertEquals("Hi", new String("Hi"));
		assertEquals(new File("test"), new File("test"));
	}

	@Test
	@DisplayName("assertNotEquals Examples")
	void test_assertNotEquals() {
		assertNotEquals(10, 100);
		assertNotEquals(true, false, "assertEquals Failure Message");
		assertNotEquals("Hi", new String("Hello"));
		assertNotEquals(new File("test"), new File("test1"));
	}

	@Test
	@DisplayName("assertArrayEquals Examples")
	void test_assertArrayEquals() {
		String[] s1 = { "A", "B" };
		String[] s2 = { "A", "B" };
		assertArrayEquals(s1, s2);
		assertArrayEquals(s1, s2, "My Custom Failure Message");
	}

	@Test
	@DisplayName("assertIterableEquals Examples")
	void test_assertIterableEquals() {
		List<String> l1 = new ArrayList<>(Arrays.asList("A", "B"));
		List<String> l2 = new LinkedList<>(Arrays.asList("A", "B"));
		assertIterableEquals(l1, l2);
		assertIterableEquals(l1, l2, "Custom Failure Message");
	}

	@Test
	@DisplayName("assertThrows Examples")
	void test_assertThrows() {
		assertThrows(RuntimeException.class, () -> {
			throw new RuntimeException();
		});
		assertThrows(Exception.class, () -> {
			throw new RuntimeException();
		});

		// this will fail
		// assertThrows(IOException.class, () -> {throw new RuntimeException();});

		// assertThrows(IOException.class, () -> {throw new RuntimeException();},
		// "assertThrows Failure Message");
	}

	@Test
	@DisplayName("assertDoesNotThrow Examples")
	void test_assertDoesNotThrow() {
		assertDoesNotThrow(new MyExecutable());
		assertDoesNotThrow(new MyExecutable(), "assertDoesNotThrow custom message");
	}

	@Test
	@DisplayName("assertAll Examples")
	void test_assertAll() {
		assertAll(Arrays.asList(new MyExecutable()));
		assertAll(new MyExecutable());
		assertAll(Stream.of(new MyExecutable()));
		// assertAll("My Executables Heading Error Message", () -> {throw new
		// Exception("Hi");});
	}

	@Test
	@DisplayName("assertTimeout Examples")
	void test_assertTimeout() {
		assertTimeout(Duration.ofSeconds(1), new MyExecutable());
		assertTimeout(Duration.ofSeconds(3), () -> {
			Thread.sleep(2000);
			System.out.println("Done");
		});
		// this will fail
		/*
		 * assertTimeout(Duration.ofNanos(1), () -> { Thread.sleep(20);
		 * System.out.println("Done"); },
		 * "assertTimeout Failure Message: Too less time to execute");
		 */
	}

	@Test
	@DisplayName("assertTimeoutPreemptively Examples")
	void test_assertTimeoutPreemptively() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), new MyExecutable());
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> System.out.println("Hello There"));
		// this will timeout for sure
		// assertTimeoutPreemptively(Duration.ofNanos(1), () ->
		// System.out.println("Hello There"));

		/*
		 * assertTimeoutPreemptively(Duration.ofSeconds(1), () -> { throw new
		 * RuntimeException(""); });
		 */
		assertTimeoutPreemptively(Duration.ofSeconds(1), new MyExecutable(),
				"MyExecutable didn't completed within 1 second");
		assertTimeoutPreemptively(Duration.ofSeconds(1), new MyExecutable(), () -> {
			return "MyExecutable didn't completed within 1 second";
		});
		/*
		 * assertTimeoutPreemptively(Duration.ofSeconds(2), () -> { throw new
		 * RuntimeException(""); }, "MyExecutable didn't completed within 2 second");
		 */
	}
}

class MyExecutable implements Executable {

	@Override
	public void execute() throws Throwable {
		System.out.println("Hello There!");
	}

}
