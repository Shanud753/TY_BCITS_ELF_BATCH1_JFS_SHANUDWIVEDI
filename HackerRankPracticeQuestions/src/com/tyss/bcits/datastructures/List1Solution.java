package com.tyss.bcits.datastructures;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class List1Solution 
{
	static Scanner scanner=new Scanner(System.in);
	static List list=null;
	public static void main(String[] args)
	{
		System.out.println("enter the number of line integers");
		int n=Integer.parseInt(scanner.nextLine());
		List list=new ArrayList();

		for (int i = 1; i <=n; i++) 
		{
			System.out.println("enter the elements to the line at"+i+"index");

			list.add(Integer.parseInt(scanner.nextLine()));   	
		}
		System.out.println(list.toString());
		System.out.println("enter the number of queries");
		int k=Integer.parseInt(scanner.nextLine());
		for(int j=1;j<=k;j++)
		{
			System.out.println("enter the query insert/delete");
			String query=scanner.next();

			if(query.equalsIgnoreCase("INSERT"))
			{
				System.out.println(" enter the index for insertion");
				int x=scanner.nextInt();
				System.out.println("enter the value for insertion");
				int y=scanner.nextInt();
				list.add(x, y);
				n++;
			}else if(query.equalsIgnoreCase("DELETE"))
			{
				System.out.println(" enter the index");
				int y=scanner.nextInt();
				list.remove(y);
				n--;
			}else
				System.out.println("enter valid query");
		}
		System.out.println(list);

	}



}
