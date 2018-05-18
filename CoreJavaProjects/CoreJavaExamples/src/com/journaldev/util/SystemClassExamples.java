package com.journaldev.util;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemClassExamples {

	public static void main(String[] args) {
		systemArrayCopyDemo();
		systemPropertyDemo();
		systemConsoleDemo();
		systemCurrentTimeDemo();
		systemEnvironmentVariablesDemo();
		systemSecurityManagerDemo();
		//systemIODemo();
		systemMiscDemo();
	}

	private static void systemSecurityManagerDemo() {
		SecurityManager secManager = System.getSecurityManager();
		if(secManager == null){
			System.out.println("SecurityManager is not configured");
		}
		SecurityManager mySecManager = new SecurityManager();
		System.setSecurityManager(mySecManager);
		secManager = System.getSecurityManager();
		if(secManager != null){
			System.out.println("SecurityManager is configured");
		}
	}

	private static void systemEnvironmentVariablesDemo() {
		//get unmodifiable environment variables map
		Map<String, String> envMap = System.getenv();
		Set<String> keySet = envMap.keySet();
		for(String key : keySet){
			System.out.println("Key="+key+",value="+envMap.get(key));
		}
		
		//Get Specific environment variable
		String pathValue = System.getenv("PATH");
		System.out.println("$PATH="+pathValue);
	}

	private static void systemMiscDemo() {
		//run the garbage collector
		System.gc();
		System.out.println("Garbage collector executed.");
		
		//map library name
		String libName = System.mapLibraryName("os.name");
		System.out.println("os.name library="+libName);
		
		//load external libraries
		//System.load("lixSYX.so");
		//System.loadLibrary("libos.name.dylib");
		
		//run finalization
		System.runFinalization();
		
		//terminates the currently running JVM
		System.exit(1);
		// this line will never print because JVM is terminated
		System.out.println("JVM is terminated"); 
	}

	private static void systemIODemo() {
		try(FileInputStream fis = new FileInputStream("input.txt");
				FileOutputStream fos = new FileOutputStream("server.log");) {
			
			//set input stream
			System.setIn(fis);
			char c = (char) System.in.read();
			System.out.print(c); //prints the first character from input stream
			
			//set output stream
			System.setOut(new PrintStream(fos));
			System.out.write("Hi Pankaj\n".getBytes());
			
			//set error stream
			System.setErr(new PrintStream(fos));
			System.err.write("Exception message\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void systemCurrentTimeDemo() {
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		System.out.println("Current time in millis="+currentTimeMillis);
		System.out.println(date); //prints 2013-08-05
		
		long nanoTime = System.nanoTime();
		System.out.println("Current nano time="+nanoTime);
	}

	private static void systemConsoleDemo() {
		Console console = System.console();
		if(console != null){
		Calendar c = new GregorianCalendar();
		console.printf("Welcome %1$s%n", "Pankaj"); //prints "Welcome Pankaj"
		console.printf("Current time is: %1$tm %1$te,%1$tY%n", c); //prints "Current time is: 08 5,2013"
		console.flush();
		}else{
			//No console is attached when run through Eclipse, background process
			System.out.println("No Console attached");
		}
	}

	private static void systemPropertyDemo() {
		//Get System Defined Properties
		Properties systemProps = System.getProperties();
		Set<Object> keySet = systemProps.keySet();
		for(Object obj : keySet){
			String key = (String) obj;
			System.out.println("{"+obj+"="+systemProps.getProperty(key)+"}");
		}
		
		//Get Specific Property
		System.out.println(System.getProperty("user.country"));
		
		//Clear property example
		System.clearProperty("user.country");
		System.out.println(System.getProperty("user.country")); //print null
		
		//Set System property
		System.setProperty("user.country", "IN");
		System.out.println(System.getProperty("user.country")); //prints "IN"
	}

	private static void systemArrayCopyDemo() {
		int [] array1 = {1,2,3,4,5};
		int[] array2 = {10,20,30,40,50};
		
		//copying first two elements from array1 to array2 starting from index 2 of array2
		System.arraycopy(array1, 0, array2, 2, 2);
		
		System.out.println(Arrays.toString(array2));
	}

}
