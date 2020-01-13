package com.bcits.hackerrank.generaltype;

import java.util.Scanner;

public class CompanyNameFromEmail {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
  
		System.out.println("Enter the String");
        String str = scanner.next();
		String domain = str .substring(str .indexOf("@") + 1);
		String name = domain.substring(0, domain.indexOf("."));
		System.out.println(name);
		
	}
}