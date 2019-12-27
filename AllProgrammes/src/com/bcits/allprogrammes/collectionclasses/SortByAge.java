package com.bcits.allprogrammes.collectionclasses;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee2> 
{

	@Override
	public int compare(Employee2 o1, Employee2 o2) {
	
		return o1.eid-o2.eid;
	}

}
