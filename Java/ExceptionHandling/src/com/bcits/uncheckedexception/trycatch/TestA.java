package com.bcits.uncheckedexception.trycatch;

public class TestA
{
public static void main(String[] args) 
{
	String name=null;
	
	System.out.println("main started");
	try {
	
		System.out.println(10/0);
		System.out.println(name.length());// not executed as only one stmt in try catch will get executed
	}
	catch(ArithmeticException |NullPointerException  a)
	{
		System.out.println(a.getMessage());
	}
	
	System.out.println("main ended");
}
}
