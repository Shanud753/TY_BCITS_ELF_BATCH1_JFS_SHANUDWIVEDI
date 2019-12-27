package com.bcits.collectioninterface.list;

import java.util.*;

public class ArrayList1 {
	public static void main(String[] args) 

	{
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(16);
		a1.add(65);
		a1.add(1,76);
		System.out.println(a1);

		a1.remove(1);
		System.out.println(a1);
		a1.set(0,36);
		System.out.println(a1);
		a1.add(36);
		System.out.println(a1);
		System.out.println(a1.indexOf(36));
		System.out.println(a1.lastIndexOf(36));

		for (int i = 0; i < a1.size(); i++)
		{
			System.out.println(a1.get(i));
		}
		System.out.println("*********************");
		
		List<Integer> a2= a1.subList(0, 3);
		for (int i = 0; i < a2.size(); i++)
		{
			System.out.println(a2.get(i));
		}

	}

}
