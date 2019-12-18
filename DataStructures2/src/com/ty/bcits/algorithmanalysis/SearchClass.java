package com.ty.bcits.algorithmanalysis;
import java.util.*;
public class SearchClass
{
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		LinearSearch l=new LinearSearch();
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
	   l.search(a, n, key);
		
	}

}
