package com.journaldev.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JDK10CollectionFunctions {

	public static void main(String[] args) {

		// 1. List, Set, Map copyOf(Collection) method
		List<String> actors = new ArrayList<>();

		actors.add("Jack Nicholson");
		actors.add("Marlon Brando");

		System.out.println(actors);
		// prints [Jack Nicholson, Marlon Brando]

		// New API added - Creates an UnModifiable List from a List.
		List<String> copyOfActors = List.copyOf(actors);

		System.out.println(copyOfActors);
		// prints [Jack Nicholson, Marlon Brando]

		// copyOfActors.add("Robert De Niro"); Will generate
		// UnsupportedOperationException

		actors.add("Robert De Niro");

		System.out.println(actors);
		// prints [Jack Nicholson, Marlon Brando, Robert De Niro]

		System.out.println(copyOfActors);
		// prints [Jack Nicholson, Marlon Brando]

		// 2. Collectors class toUnmodifiableList, toUnmodifiableSet, and
		// toUnmodifiableMap methods
		List<String> collect = actors.stream().collect(Collectors.toUnmodifiableList());
		System.out.println(collect);
	}

}
