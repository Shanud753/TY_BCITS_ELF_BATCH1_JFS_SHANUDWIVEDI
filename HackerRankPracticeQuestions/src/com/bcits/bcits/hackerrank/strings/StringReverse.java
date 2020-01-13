package com.bcits.hackerrank.strings;

import java.util.Scanner;

public class StringReverse {

	static boolean palindrome(String string) {
		int start = 0;
		int end = string.length() - 1;
		while (start < end) {

			if (string.charAt(start) != string.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the String ");
		String string = scanner.nextLine();

		if (palindrome(string))
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}
