package com.bcits.hackerrank.strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToken {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
      System.out.println("Enter the String ");
      String string = scanner.nextLine();
      StringTokenizer tokenizer = new StringTokenizer(string, " ' ");
      
      System.out.println("Total number of tokens found : " + tokenizer.countTokens());
       
      while (tokenizer.hasMoreTokens())
      {
          System.out.println(tokenizer.nextToken());
      }
	}
}
