package com.bcits.collectioninterface.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1
{
public static void main(String[] args) 
{
	LinkedList<Integer> l1=new LinkedList<Integer>();
	l1.add(88);
	l1.add(98);
	l1.add(60);
	System.out.println(l1);
	
	System.out.println("*************************");
	l1.remove(0);
	System.out.println(l1);

	System.out.println("*************************");
	System.out.println(l1.isEmpty());
	System.out.println(l1);
	
	System.out.println("*************************");
	System.out.println(l1.size());
	
	System.out.println("*************************");
	System.out.println(l1.contains(98));
	System.out.println(l1);
	
	System.out.println("*************************");
	l1.set(1, 99);
	System.out.println(l1);
	
	Iterator<Integer> itr=l1.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
	
}
}
