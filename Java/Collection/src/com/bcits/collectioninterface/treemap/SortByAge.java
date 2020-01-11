package com.bcits.collectioninterface.treemap;

import java.util.Comparator;

public class SortByAge implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
	
		return o1.age - o2.age;
	}

}