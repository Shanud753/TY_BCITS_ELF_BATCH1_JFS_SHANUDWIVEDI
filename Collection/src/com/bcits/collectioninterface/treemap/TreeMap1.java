package com.bcits.collectioninterface.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 
{
   public static void main(String[] args) 
   {
	  SortByAge age=new SortByAge();
	   
	TreeMap<Person, Integer> t1=new TreeMap<Person, Integer>(age);
	t1.put(new Person(12,"manu"), 44);
	t1.put(new Person(23,"annu"), 45);
	t1.put(new Person(26,"sheenu"), 46);
	t1.put(new Person(2,"beenu"), 49);
	
	    Set<Map.Entry<Person, Integer>> s1= t1.entrySet();
	    for (Map.Entry<Person, Integer> entry : s1)
	    {
			System.out.println(entry);
		}
	
	
}
}
