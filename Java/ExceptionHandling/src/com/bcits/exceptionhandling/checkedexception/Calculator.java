package com.bcits.exceptionhandling.checkedexception;

public class Calculator
{
   String name;
   
   
   void division(int a , int b)
   {
	   try {
		   Class.forName("Person");
	   }
	   catch(ClassNotFoundException e)
	   {
		   System.out.println("class is not found");
	   }
   }
}
