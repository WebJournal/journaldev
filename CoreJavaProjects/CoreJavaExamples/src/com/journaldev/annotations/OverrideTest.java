package com.journaldev.annotations;

public class OverrideTest {

    public static void main(String[] args) {
        BaseClass bc = new ChildClass();
        bc.doSomething("override");
    }

}
