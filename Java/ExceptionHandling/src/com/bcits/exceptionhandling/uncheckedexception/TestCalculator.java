package com.bcits.exceptionhandling.uncheckedexception;

public class TestCalculator
{
	public static void main(String[] args)
	{
		System.out.println("main started");
		Calculator c1=new Calculator();
		c1.division(100, 20);
		c1.division(100, 0);
		c1.division(20,5);
		c1.division(100, 5);
		
		System.out.println("main ended");
	}

}
