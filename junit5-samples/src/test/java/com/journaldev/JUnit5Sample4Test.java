package com.journaldev;

import org.junit.jupiter.api.*;
 
class JUnit5Sample4Test {
 
    @BeforeAll
    static void beforeAll() {
    	System.out.println("**--- JUnit5Sample4Test :: beforeAll :: Executed once before all test methods ---**");
    }
 
    @BeforeEach
    void beforeEach() {
    	System.out.println("**--- JUnit5Sample4Test :: beforeEach :: Executed before each test method ---**");
    }
 
    @AfterEach
    void afterEach() {
    	System.out.println("**--- JUnit5Sample4Test :: afterEach :: Executed after each test method ---**");
    }
 
    @AfterAll
    static void afterAll() {
    	System.out.println("**--- JUnit5Sample4Test :: afterAll :: Executed after all test method ---**");
    }
 
    @Nested
    class InnerClass {
 
        @BeforeEach
        void beforeEach() {
        	System.out.println("**--- InnerClass :: beforeEach :: Executed before each test method ---**");
        }
 
        @AfterEach
        void afterEach() {
        	System.out.println("**--- InnerClass :: afterEach :: Executed after each test method ---**");
        }
 
        @Test
        void testMethod1() {
        	System.out.println("**--- InnerClass :: testMethod1 :: Executed test method1 ---**");
        }
 
        @Nested
        class InnerMostClass {
 
            @BeforeEach
            void beforeEach() {
            	System.out.println("**--- InnerMostClass :: beforeEach :: Executed before each test method ---**");
            }
 
            @AfterEach
            void afterEach() {
            	System.out.println("**--- InnerMostClass :: afterEach :: Executed after each test method ---**");
            }
 
            @Test
            void testMethod2() {
            	System.out.println("**--- InnerMostClass :: testMethod2 :: Executed test method2 ---**");
            }
        }
    }
}