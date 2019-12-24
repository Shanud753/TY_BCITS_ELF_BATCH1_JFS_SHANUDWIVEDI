package com.tyss.bcits.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1Solution
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the number of lines...");
		int n=scanner.nextInt();
		ArrayList<ArrayList<Integer>> arraylists=new ArrayList<ArrayList<Integer>>(n);
		ArrayList<Integer> arraylist=null;

		for (int i = 1; i<=n; i++)
		{
			System.out.println("enter the digits at line "+i);
			int d=scanner.nextInt();
			arraylist=new ArrayList<Integer>(d);
			arraylist.add(0,d);

			for(int j=1;j<=n;j++)
			{
				System.out.println("enter the element at line  "+j+"th pos");
				int x=scanner.nextInt();
				arraylist.add(x);
			}

			System.out.println(arraylist.toString());
			arraylists.add(arraylist);
		}


		System.out.println(arraylists.toString());
		
		
		System.out.println("enter the number of queries");
		int k=scanner.nextInt();
		for(int i=1;i<=k;k++)
		{
			System.out.println("enter the line number");
			int x=scanner.nextInt();
			System.out.println("enter the position on the line number");
			int y=scanner.nextInt();
			System.out.println(arraylists.get(x-1).get(y-1));
		}
		scanner.close();
	}
	}
	


