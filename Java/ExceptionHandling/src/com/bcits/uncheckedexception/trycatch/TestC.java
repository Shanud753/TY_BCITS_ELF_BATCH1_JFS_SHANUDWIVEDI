package com.bcits.uncheckedexception.trycatch;

public class TestC 
{
	public static void main(String[] args) {
		
		System.out.println("main started");
		try {
			A.a();
		}
		catch(ArithmeticException a)
		{
			System.out.println(a.getMessage());
		}
		System.out.println("main ended");
	}
	

}
