package com.bcits.allprogrammes.collectionclasses;
import java.util.*;
public class MainClass3 {
 public static void main(String[] args)
 {
	 Scanner  s1=new Scanner(System.in);
	 
	Employee2 e=new Employee2("bita",4,400);
	Employee2 e2=new Employee2("ita",2,100);
	Employee2 e3=new Employee2("anita",1,900);
	
	System.out.println("enter your choice for sorting as 1 , 2 ,3");
	int k=s1.nextInt();
	
	SortByName n=new SortByName();
	SortByAge a=new SortByAge();
	SortBySalary s=new SortBySalary();
	
		 if(k==1) {
	System.out.println("employee sorted by name");
	TreeSet<Employee2> t=new TreeSet<Employee2>(n);
	t.add(e);
	t.add(e2);
	t.add(e3);
	for( Employee2 e1:t)
	{
		System.out.println(e1);
	}
	
}
		 else if(k==2)
		 {
			 System.out.println("employee sorted by age");
			 TreeSet<Employee2> t=new TreeSet<Employee2>(a);
				t.add(e);
				t.add(e2);
				t.add(e3); 
				for( Employee2 e1:t)
				{
					System.out.println(e1);
				}
		 }
		 
		 else
		 {
			 System.out.println("employee sorted by salary");
			 TreeSet<Employee2> t=new TreeSet<Employee2>(s);
				t.add(e);
				t.add(e2);
				t.add(e3); 
				
				for( Employee2 e1:t)
				{
					System.out.println(e1);
				}
		 }
}
}
