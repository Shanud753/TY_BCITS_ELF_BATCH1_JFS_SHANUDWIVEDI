package com.bcits.hackerrank.oops;

public class Inheritance2 {
	public static void main(String[] args) {
		
		Adder ad = new Adder();

		System.out.println("My superclass is: " + ad.getClass().getSuperclass().getSimpleName());
		System.out.print(ad.add(10,32) + " " + ad.add(10,3) + " " + ad.add(10,10) + "\n");
	}
}
