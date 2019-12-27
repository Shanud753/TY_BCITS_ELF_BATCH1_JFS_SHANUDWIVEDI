package com.bcits.collectioninterface.mapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 
{
	public static void main(String[] args) {

		HashMap<Integer, String> h1=new HashMap<Integer, String>();
		h1.put(25, "abhi");
		h1.put(2,"Divya");
		h1.put(78,"monu");
		h1.put(13,"reenu");

		Set<Map.Entry<Integer,String>> s1=h1.entrySet();
		for (Map.Entry<Integer, String> entry : s1) 
		{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("--------------------------");
		}
		System.out.println(h1.get(13));

		Set<Integer> s2=h1.keySet();
		for(Integer integer:s2)
		{
			System.out.println(integer);
		}
		Collection<String> c1=h1.values();
		for(String string:c1)
		{
			System.out.println(string);
		}
	}

}
