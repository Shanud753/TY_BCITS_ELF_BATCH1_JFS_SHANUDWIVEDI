package com.bcits.exceptionhandling.checkedexception;

public class TestA 
{
	public static void main(String[] args) 
	{
		System.out.println("main started");
		Calculator c1= new Calculator();
		c1.division(100, 20);
		System.out.println("main ended");
	}

}
