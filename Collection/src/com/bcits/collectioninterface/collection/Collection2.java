package com.bcits.collectioninterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {
	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(12);
		c1.add(45);
		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(1);
		c2.add(45);
		c2.add(89);
		System.out.println(c1);
		System.out.println(c2);
		c2.addAll(c1);
		System.out.println("************************************");
		System.out.println(c1);
		System.out.println(c2);
		c2.removeAll(c1);
		System.out.println("************************************");
		System.out.println(c1);
		System.out.println(c2);
		
		
		System.out.println("*****************containsAll() and removeAll()*******************");
	
		Collection<Integer> c3 = new ArrayList<Integer>();
		c3.add(12);
		c3.add(45);
		c3.add(78);
		Collection<Integer> c4 = new ArrayList<Integer>();
		c4.add(1);
		c4.add(45);
		c4.add(89);
		c4.add(78);
		System.out.println(c4.containsAll(c3));
		
		System.out.println(c3);
		System.out.println(c4);
		c4.retainAll(c3);
		
		System.out.println("*********************************");
		System.out.println(c3);
		System.out.println(c4);
		
		System.out.println("**************toArray()*******************");
		Object[] o1=c4.toArray();
		for (int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
			
		}
		
	}

}
