package com.tyss.bcits.datastructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Map1Solution {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the number of entries for phonebook");
		int n = scanner.nextInt();
		LinkedHashMap<String, Long> hash = new LinkedHashMap<String, Long>();

		for (int i = 0; i < n; i++) {
			System.out.println("enter the name of person");
			String name = scanner.next();
			System.out.println("enter the phone number of the person");
			Long l = scanner.nextLong();
			hash.put(name, l);
		}

		
		Set s = hash.keySet();
		Iterator i = s.iterator();

		while (i.hasNext()) {
			String name1 = (String) i.next();
			Long value = hash.get(name1);
			System.out.println("enter the name which u want to search in phonebook");
			String name11 = scanner.next();

			if (name1.equals(name11)) {
				System.out.println("name is  : " + name11 + " and phone number is  : " + value);
			}

			else {
				System.out.println("details not found in phonebook");

			}

		}
	}
}
