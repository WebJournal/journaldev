package com.journaldev.repeatedtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTestExample {

	@RepeatedTest(value = 5)
	void test() {
		System.out.println("@RepeatedTest Simple Example");
	}

	@RepeatedTest(3)
	void test_with_RepetitionInfo_Injection(RepetitionInfo repetitionInfo) {
		System.out.println("@RepeatedTest with RepetitionInfo Injection");
		assertEquals(3, repetitionInfo.getTotalRepetitions());

		// below code shouldn't be part of test method
		// move it to @BeforeEach/@AfterEach
		// System.out.println("Current Test Count = "+repetitionInfo.getCurrentRepetition());
	}

	@BeforeEach
	void setUp(RepetitionInfo repetitionInfo, TestInfo testInfo) {
		System.out.println("Method = " + testInfo.getTestMethod().get().getName() + ", Execution Count = "
				+ repetitionInfo.getCurrentRepetition());
	}

	@RepeatedTest(value = 2, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("MyTest")
	void test_with_cutom_DisplayName(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
}
