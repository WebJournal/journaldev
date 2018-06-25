package com.journaldev.dynamictests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import com.journaldev.utils.MyUtils;

public class JUnit5DynamicTests {

	@TestFactory
    Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(
            dynamicTest("simple dynamic test", () -> assertTrue(true)),
            dynamicTest("My Executable Class", new MyExecutable()),
         //   dynamicTest("Exception Executable", () -> {throw new Exception("Exception Example");}),
            dynamicTest("simple dynamic test-2", () -> assertTrue(true))
        );
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicTestsExample() {
		List<Integer> input1List = Arrays.asList(1,2,3);
		List<Integer> input2List = Arrays.asList(10,20,30);
		
		List<DynamicTest> dynamicTests = new ArrayList<>();
		
		for(int i=0; i < input1List.size(); i++) {
			int x = input1List.get(i);
			int y = input2List.get(i);
			DynamicTest dynamicTest = dynamicTest("Dynamic Test for MyUtils.add("+x+","+y+")", () ->{assertEquals(x+y,MyUtils.add(x,y));});
			dynamicTests.add(dynamicTest);
		}
		
		return dynamicTests.stream();
	}
	
}

class MyExecutable implements Executable {

	@Override
	public void execute() throws Throwable {
		System.out.println("Hello World!");
	}

}
