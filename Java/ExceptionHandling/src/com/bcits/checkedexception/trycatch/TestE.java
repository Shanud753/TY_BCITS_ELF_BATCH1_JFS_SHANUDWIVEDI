package com.bcits.checkedexception.trycatch;

public class TestE {
	public static void main(String[] args) {
		System.out.println("main started");
		Person p1=new Person();
		try {
			p1.clone();
			System.out.println("object cloned");
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}

}
