package com.bcits.allprogrammes.collectionclasses;

import java.util.ArrayList;
import java.util.Iterator;

public class Student2 
{
public static void main(String[] args) 
{
	Student s1=new Student();
	s1.setId(1);
	s1.setName("xyz");
	

	
	Student s2=new Student();
	s2.setId(2);
	s2.setName("abs");
	
	
	
	Student s3=new Student();
	s3.setId(3);
	s3.setName("yxv");
	

	
	Student s4=new Student();
	s4.setId(4);
	s4.setName("www");
	
	Student s5=new Student();
	s5.setId(5);
	s5.setName("ram");
	
	ArrayList a=new ArrayList();
	a.add(s1.getId());
	a.add(s1.getName());
	
	a.add(s2.getId());
	a.add(s2.getName());
	
	a.add(s3.getId());
	a.add(s3.getName());
	
	a.add(s4.getId());
	a.add(s4.getName());
	
	a.add(s5.getId());
	a.add(s5.getName());
	
    Iterator i=a.iterator();
    while(i.hasNext())
    {
    	System.out.println(i.next());
    }
}
}
