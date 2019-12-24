package com.tyss.bcits.datastructures;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Sorting {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
       System.out.println("enter the total number of students");
       int total=Integer.parseInt(scanner.nextLine());
       SortStudent sort=new SortStudent();
       TreeSet tree=new TreeSet(sort);
      // String name=null;
       
       for(int i=0;i<total;i++) 
       {
    	   System.out.println("enter the id");
    	   int id=scanner.nextInt();
    	   System.out.println("enter the name");
    	   String name=scanner.next();
    	   System.out.println("enter the marks");
    	   int marks=scanner.nextInt();
    	   Student s1=new Student(id, name, marks);
    	   tree.add(s1);
       }
         //for(int j=0;j<)
    	   
    	 /*  Iterator i1=tree.iterator();
    	   while(i1.hasNext())
    	   {
    		   Student name1=(Student) i1.next();
    		   System.out.println(name1);
    	   }
    	   */
    	   
    	 
    	
    	 
    	   	   
	}
}

