package com.tyss.bcits.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashSet1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the number of pairs");
		int t = Integer.parseInt(scanner.nextLine());
		HashSet<String> hash = new HashSet<String>();
		ArrayList<Integer> list = new ArrayList<Integer>();


		for (int i = 1; i <=t; i++) {
			System.out.println("enter the "+i+" pair");
			String fname = scanner.nextLine();
			
			int count = 0;
			
			hash.add(fname);
			for(Object t1:hash)
			{
				count++;
			}
			
			list.add(count);
		}

		for (int pair : list)
		{
			System.out.println("the unique pair are"+pair);

		}
	}
}
