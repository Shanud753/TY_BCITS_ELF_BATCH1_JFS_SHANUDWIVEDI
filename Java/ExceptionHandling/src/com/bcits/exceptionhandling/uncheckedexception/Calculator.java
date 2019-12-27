package com.bcits.exceptionhandling.uncheckedexception;

public class Calculator
{
    void add(int a ,int b)
    {
    	System.out.println(a+b);
    }
    
    void division(int a ,int b)
    {
    	try {
    	System.out.println(a/b);
    }
    	catch(ArithmeticException e)
    	{
    		System.out.println("MATH ERROR");
    	}
}
}
