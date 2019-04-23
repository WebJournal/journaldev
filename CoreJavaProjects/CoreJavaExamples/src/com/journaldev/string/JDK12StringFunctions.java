package com.journaldev.string;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JDK12StringFunctions {

	public static void main(String[] args) {
		String str = "*****\n  Hi\n  \tHello Pankaj\rHow are you?\n*****";

		// 1. public String indent​(int n)
		System.out.println(str.indent(0));
		System.out.println(str.indent(3));
		System.out.println(str.indent(-3));

		// 2. public <R> R transform​(Function<? super String,​? extends R> f)
		String s = "Hi,Hello,Howdy";
		List<String> strList = s.transform(s1 -> {return Arrays.asList(s1.split(","));});
		System.out.println(strList);

		//Java 12 String implements Constable, ConstantDesc - hence two new methods
		// 3. public Optional<String> describeConstable()
		String so = "Hello";
		Optional<String> os = so.describeConstable();
		System.out.println(os);
		System.out.println(os.get());
		
		// 4. public String resolveConstantDesc​(MethodHandles.Lookup lookup)
		String so1 = "Hello";
		System.out.println(so1.resolveConstantDesc(MethodHandles.lookup()));
		
		
	}

}
