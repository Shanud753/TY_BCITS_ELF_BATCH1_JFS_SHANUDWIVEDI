package com.tyss.bcits.datastructures;

import java.util.Iterator;
	import java.util.Scanner;
	import java.util.TreeSet;

	public class Sorting  {
		static Scanner scanner = new Scanner(System.in);

		public static void main(String[] args)
		{
	       System.out.println("enter the total number of students");
	       int total=Integer.parseInt(scanner.nextLine());
	       SortStudent sort=new SortStudent();
	       TreeSet<Student> tree=new TreeSet<Student>();
	       
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
	      
	    	   for(Student n:tree)
	    	   {
	    		   System.out.println(n.getName());
	    	   }
	    	   
	    	 
	    	
	    	 
	    	   	   
		}

	}


