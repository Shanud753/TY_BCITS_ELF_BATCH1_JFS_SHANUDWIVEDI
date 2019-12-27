package com.bcits.collectioninterface.treeset;

import java.util.TreeSet;

public class TreeSet1
{
public static void main(String[] args) 
{
	
	
	Person p1=new Person(12, "annu");
	Person p2=new Person(27,"zeena");
	Person p3=new Person(1, "diksha");
	Person p4=new Person(24, "punnu");
	
	TreeSet <Person> t1=new TreeSet<Person>(new SortAge());
	t1.add(p1);
	t1.add(p2);
	t1.add(p3);
	t1.add(p4);
	
	System.out.println(t1);
	
	
	
	
	
}
}
