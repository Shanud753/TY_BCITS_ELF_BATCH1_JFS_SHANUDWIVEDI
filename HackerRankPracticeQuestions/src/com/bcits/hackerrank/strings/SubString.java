package com.bcits.hackerrank.strings;
//I love Coding

import java.util.Scanner;

public class SubString {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the  String ");
		String string1 = scanner.nextLine();
		System.out.println("Enter the starting & Ending index");
		int index1=scanner.nextInt();
		int index2=scanner.nextInt();
		String string2=string1.substring(index1, index2);
		System.out.println(string2);
	}
}
