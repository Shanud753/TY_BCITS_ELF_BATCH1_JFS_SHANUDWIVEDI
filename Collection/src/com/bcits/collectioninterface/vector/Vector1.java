package com.bcits.collectioninterface.vector;

import java.util.Iterator;
import java.util.Vector;

public class Vector1
{
public static void main(String[] args) 
{
	Vector<Integer> v1=new Vector<Integer>();
	
	
	v1.add(88);
	v1.add(98);
	v1.add(60);
	System.out.println(v1);
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  

	v1.add(98);
	v1.add(null);
	
    //v1.setElementAt(55, 2);
    System.out.println(v1.capacity());//gives the initial capacity of vector
   
	System.out.println(v1);
	
	System.out.println("*************************");
	v1.remove(0);
	System.out.println(v1);

	System.out.println("*************************");
	System.out.println(v1.isEmpty());
	System.out.println(v1);
	
	System.out.println("*************************");
	System.out.println(v1.size());
	
	System.out.println("*************************");
	System.out.println(v1.contains(98));
	System.out.println(v1);
	
	System.out.println("*************************");
	v1.set(1, 99);
	System.out.println(v1);
	
	Iterator<Integer> itr=v1.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
	
	
	Vector<Integer> v2=new Vector<Integer>();
	v2.insertElementAt(12,0);
	v2.insertElementAt(45, 1);
	System.out.println(v2);
	v2.removeElement(new Integer(12));
	System.out.println(v2);
	
	System.out.println(v2.capacity());
	System.out.println(v2.size());
	v2.trimToSize();
	System.out.println(v2.capacity());
	System.out.println(v2.size());
	v2.ensureCapacity(5);
	System.out.println("------------ensureCapacity()-----------");
	System.out.println(v2.capacity());
	
}
}
