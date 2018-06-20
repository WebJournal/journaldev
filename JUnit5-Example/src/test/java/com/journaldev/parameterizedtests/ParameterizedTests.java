package com.journaldev.parameterizedtests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTests {

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void test_ValueSource(int i) {
		System.out.println(i);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "1", "2", "3" })
	void test_ValueSource_String(String s) {
		assertTrue(Integer.parseInt(s) < 5);
	}

	@ParameterizedTest
	@EnumSource(ElementType.class)
	void test_EnumSource(ElementType et) {
		System.out.println(et);
	}

	@ParameterizedTest
	@EnumSource(value = ElementType.class, names = { "TYPE", "METHOD", "FIELD" })
	void test_EnumSource_Extended(ElementType et) {
		assertTrue(EnumSet.of(ElementType.FIELD, ElementType.TYPE, ElementType.METHOD).contains(et));
	}

	@ParameterizedTest
	@MethodSource("ms")
	void test_MethodSource(String s) {
		assertNotNull(s);
	}

	static Stream<String> ms() {
		return Stream.of("A", "B");
	}

	@ParameterizedTest
	@MethodSource("com.journaldev.parameterizedtests.MethodSources#msMP")
	void test_MethodSource_MultipleParams(int i, String s) {
		assertTrue(4 > i);
		assertTrue(Arrays.asList("A", "B", "C").contains(s));
	}

	static Stream<Arguments> msMP() {
		return Stream.of(Arguments.of(1, "A"), Arguments.of(2, "B"));
	}
	
	@ParameterizedTest
	@CsvSource(delimiter='|', value= {"1|'A'","2|B"})
	void test_CsvSource(int i, String s) {
		assertTrue(3 > i);
		assertTrue(Arrays.asList("A", "B", "C").contains(s));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/country_code.csv", numLinesToSkip = 1)
	void test_CsvFileSource(String country, int code) {
	    assertNotNull(country);
	    assertTrue(0 < code);
	}
	
	@ParameterizedTest
	@MethodSource("mpBooks")
	void test_MethodSource_Objects(Book b) {
		assertNotNull(b.getTitle());
	}

	static Book[] mpBooks() {
		return new Book[] {new Book("Harry Potter"), new Book("Five Point Someone")};
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Harry Potter", "Hamlet"})
	void test_ValueSource_Objects(Book b) {
		assertNotNull(b.getTitle());
	}
}

class Book {
	private String title;

	public Book(String t) {
		this.title = t;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
