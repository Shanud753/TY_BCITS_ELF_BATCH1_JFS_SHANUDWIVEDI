package com.tyss.bcits.datastructures;
import java.util.Scanner;

	public class Array1D 
	{
		static Scanner scanner=new Scanner(System.in);
		public static void main(String[] args) 
		{
			System.out.println("enter the size of array");
			int n=Integer.parseInt(scanner.nextLine());
			int[] a1=new int[n];
			for (int i = 0; i < n; i++) {
				System.out.println("enter the "+i+"th element to the array");
				int x=Integer.parseInt(scanner.nextLine());
				a1[i]=x;

			}

			for (int i = 0; i < a1.length; i++)
			{
				System.out.println(a1[i]);
			}

		}
	}


