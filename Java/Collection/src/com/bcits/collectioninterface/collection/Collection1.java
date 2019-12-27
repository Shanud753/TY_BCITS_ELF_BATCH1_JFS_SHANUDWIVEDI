package com.bcits.collectioninterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1
{
public static void main(String[] args) {
	Collection<Integer> c1=new ArrayList<Integer>();
	c1.add(34);
	c1.add(78);
	c1.add(52);
	System.out.println(c1);
	c1.remove(34);
	System.out.println(c1);
	System.out.println(c1.isEmpty());
	System.out.println(c1.size());
	System.out.println(c1.contains(52));
	Collection<Integer> c2=new ArrayList<Integer>();
	c2.addAll(c1);
	c2.add(67);
	System.out.println(c2);
	System.out.println(c2.containsAll(c1));
	
}
}
