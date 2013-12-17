package com.journaldev.util;

public class T {
public static void main(String[] args) throws Exception {
	B b=null;
try (B b1= new B(); A a = new A(b1)) {
System.out.println("inside arm block");
}
}
private static class A implements AutoCloseable {
public A(B b) {System.out.println(b);}
public void close() throws Exception {
System.out.println("running A.close()");
}
}

private static class B implements AutoCloseable {
public void close() throws Exception {
System.out.println("running B.close()");
}
}
}