package com.bcits.hackerrank.strings;
//I love Coding

import java.util.Scanner;

public class String1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the 1st String ");
		String string1 = scanner.nextLine();
		System.out.println("Enter the 2nd String");
		String string2 = scanner.nextLine();
		String string = "";
		int len1 = string1.length();
		int len2 = string2.length();
		int lenF = len1 + len2;
		System.out.println(lenF);
		int result = string1.compareTo(string2);
		if (result < 0) {
			System.out.println("No");
		}

		else {
			System.out.println("Yes");
		}
		string1 = string1.substring(0, 1).toUpperCase() + string1.substring(1);
		string2 = string2.substring(0, 1).toUpperCase() + string2.substring(1);
		System.out.println(string1 + " " + string2);

	}
}
