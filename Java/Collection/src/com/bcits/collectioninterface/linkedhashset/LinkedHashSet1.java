package com.bcits.collectioninterface.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSet1 
{
	public static void main(String[] args)
	{
		LinkedHashSet<Integer> l1=new LinkedHashSet<Integer>();
		l1.add(20);
		l1.add(12);
		l1.add(2);
		l1.add(89);
		l1.add(6);
		 
		System.out.println(l1);
		
		l1.remove(2);
		System.out.println(l1);
		l1.remove(6);
	    System.out.println(l1);
	    
	    l1.add(null);
	    System.out.println(l1); //follow insertion order
		
	}

}
