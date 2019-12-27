package com.bcits.allprogrammes.collectionclasses;

import java.util.ArrayList;

public class Eclass 
{
public static void main(String[] args) 
{
	Employee e1=new Employee("hi",1);
	Employee e2=new Employee("whi",2);
	ArrayList<Employee> a=new ArrayList<Employee>();
	
	a.add(e1);
	a.add(e2);
	
	for(Employee e:a)
	{
		System.out.println(e);
	}
}
}
