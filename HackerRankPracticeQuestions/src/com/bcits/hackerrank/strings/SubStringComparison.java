package com.bcits.hackerrank.strings;

import java.util.Scanner;

public class SubStringComparison {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the  String ");
		String string1 = scanner.nextLine();
		int lenT=string1.length();
		System.out.println("enter how many characters u want to display");
		int len1=scanner.nextInt();
//		int lenH=lenT-len1;
		for (int i = 0; i <len1; i++) {
			int result=string1.compareTo(string1);
		}
	}
}
