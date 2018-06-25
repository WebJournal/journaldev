package com.journaldev.disabletests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import java.util.Set;

import org.junit.jupiter.api.Disabled;

//@Disabled
class DisabledTests {

	@Test
	@Disabled("Explicitly Disabled")
	void test() {
		assertTrue(3 > 0);
	}

	@Test
	// printing system properties, they are being used in further tests
	void test1() {
		assertFalse(3 < 0);
		System.out.println(System.getenv());
		Properties properties = System.getProperties();
		Set<Object> keySet = properties.keySet();
		for (Object o : keySet) {
			System.out.println("KEY=" + o + ", VALUE=" + properties.getProperty(o.toString()));
		}
	}

	@Test
	@DisabledOnOs(value = { OS.MAC, OS.WINDOWS })
	void test2() {
		assertFalse(3 < 0);
	}

	@Test
	@EnabledOnOs(value = { OS.MAC })
	void test3() {
		assertTrue(System.getProperty("os.name").startsWith("Mac"));
	}

	@Test
	@DisabledOnJre(value = JRE.JAVA_10)
	void test4() {
		assertFalse(3 < 0);
	}

	@Test
	@EnabledOnJre(value = JRE.JAVA_10)
	void test5() {
		assertTrue(System.getProperty("java.version").startsWith("10"));
	}

	@Test
	@DisabledIfEnvironmentVariable(named = "USER", matches = "pankaj")
	void test6() {
		assertFalse(3 < 0);
	}

	@Test
	@EnabledIfEnvironmentVariable(named = "USER", matches = "pankaj")
	void test7() {
		assertTrue("pankaj".equals(System.getenv("USER")));
	}

	@Test
	// My System Properties "os.name" value is "Mac OS X"
	@DisabledIfSystemProperty(named = "os.name", matches = "Mac.*")
	void test8() {
		assertFalse(3 < 0);
	}

	@Test
	// My System Properties "user.name" value is "pankaj"
	@EnabledIfSystemProperty(named = "user.name", matches = "pankaj")
	void test9() {
		assertTrue("pankaj".equals(System.getProperty("user.name")));
	}

	@Test
	@DisabledIf("'pankaj' == systemEnvironment.get('USER')")
	void test10() {
		assertFalse(3 < 0);
	}

	@Test
	@EnabledIf("'pankaj' == systemProperty.get('user.name')")
	void test11() {
		assertTrue("pankaj".equals(System.getProperty("user.name")));
	}
}
