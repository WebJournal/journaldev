package com.journaldev.misc;

import java.lang.Runtime.Version;

public class CheckJavaVersion {

	public static void main(String[] args) {
		
		// Java 10 Onwards
		Version version = java.lang.Runtime.version();
		System.out.println("Java Version = "+version);
		System.out.println("Java Version Feature Element = "+version.feature());
		System.out.println("Java Version Interim Element = "+version.interim());
		System.out.println("Java Patch Element Version = "+version.patch());
		System.out.println("Java Update Element Version = "+version.update());
		System.out.println("Java Version Build = "+version.build().get());
		System.out.println("Java Pre-Release Info = "+version.pre().orElse("NA"));
		
		/** Version class introduced in Java 9
		Version version = java.lang.Runtime.version();
		System.out.println("Java Version = "+version);
		System.out.println("Java Major Version = "+version.major());
		System.out.println("Java Minor Version = "+version.minor());
		System.out.println("Java Security Version = "+version.security());
		System.out.println("Java Version Build = "+version.build().get());
		System.out.println("Java Version Pre-Release Info = "+version.pre().orElse("NA"));
		*/

		// For Java 8 or lower, use System Property
		//System.out.println(System.getProperty("java.version"));
		//System.out.println(System.getProperty("java.specification.version"));

	}

}
