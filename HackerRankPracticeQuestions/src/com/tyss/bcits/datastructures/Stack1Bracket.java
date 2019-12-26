package com.tyss.bcits.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

       public class Stack1Bracket {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the number of lines...");
		int n = Integer.parseInt(scanner.nextLine());
		Stack<String> stack = new Stack<String>();


		ArrayList array = new ArrayList();
		for (int i = 0; i < n; i++) {
			System.out.println("enter input string");
			String str = scanner.nextLine();
			int count = 0;
			stack.add(str);
		}


		Iterator i = stack.iterator();
		while(i.hasNext())
		{
			String s2=(String) i.next();
			int flag1=0;

			if ((s2.equals("()")) || (s2.equals("{}")) || (s2.equals("[{()}]")) || (s2.equals("[]"))) 
			{
				flag1=1;
			} 
			else {
				flag1=0;

			}

			if(flag1==1)
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}



		}

	}
}


