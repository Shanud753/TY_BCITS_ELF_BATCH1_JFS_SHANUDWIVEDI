package com.bcits.collectioninterface.iteratingways;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Arrayalist1 
{
public static void main(String[] args)
{
	ArrayList<Integer> a1=new ArrayList<Integer>();
	a1.add(24);
	a1.add(46);
	System.out.println("--------------Using for loop------------");
	for (int i = 0; i < a1.size(); i++)
	{
		System.out.println(a1.get(i));
	}
	
	System.out.println("--------------Using forEach loop------------");
	for (Integer integer : a1) 
	{
		System.out.println(integer);
	}
	

	System.out.println("--------------Using iterator()------------");
	Iterator<Integer> ltr=a1.iterator();
	while(ltr.hasNext())
	{
		System.out.println(ltr.next());
		//a1.add(87);  //-->it gives concurrent modification exception
	}
	
	System.out.println("--------------Using ListIterator() forward direction------------");
	ListIterator<Integer> ltr1=a1.listIterator();
	while(ltr1.hasNext())
	{
		System.out.println(ltr1.next());
	}
	
	System.out.println("--------------Using ListIterator() reverse direction------------");
	ListIterator<Integer> ltr2=a1.listIterator();
	while(ltr1.hasPrevious())
	{
		System.out.println(ltr1.previous());
	}
}
}
