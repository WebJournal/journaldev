package com.journaldev.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaSortListObject {

	public static void main(String[] args) {
		List<Data> dl = new ArrayList<>();
		dl.add(new Data(2));
		dl.add(new Data(3));
		dl.add(new Data(1));
		System.out.println("Original List::" + dl);
		Collections.sort(dl);
//		System.out.println("Naturally Sorted List::" + dl);

		// sort a list using Comparator implementation
		Collections.sort(dl, (d1, d2) -> {
			return d2.getId() - d1.getId();
		});
		System.out.println("Reverse Sorted List using Comparator::" + dl);

	}

}

class Data implements Comparable<Data> {

	private int id;

	public Data(int i) {
		this.id = i;
	}

	@Override
	public int compareTo(Data d) {
		return this.id - d.getId();
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Data{" + this.id + "}";
	}
}