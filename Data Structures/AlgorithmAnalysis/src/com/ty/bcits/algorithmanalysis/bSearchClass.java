package com.ty.bcits.algorithmanalysis;

import java.util.Scanner;

public class bSearchClass 
{
	public static void main(String[] args)
	{
		Scanner s1=new Scanner(System.in);
		BinarySearch l=new BinarySearch();
		
		System.out.println("enter the size of array");
		int n=s1.nextInt();
		int[] a=new int[n];
		
		System.out.println("enter elements to array");
		for(int i=0;i<n;i++)
		{
			a[i]=s1.nextInt();
		}
		
		System.out.println("enter the element to search");
		int key=s1.nextInt();
		l.bSearch(a, n, key);

	}
}
