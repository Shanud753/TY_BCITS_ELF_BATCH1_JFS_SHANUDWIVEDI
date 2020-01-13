package com.bcits.hackerrank.strings;

import java.util.Scanner;

public class SubStringComparison {
    public static void getSmallestAndLargestSubString(String s, int k) 
    { 
        String currentStr = s.substring(0, k); //divide the string based on k value
        String lenMin = currentStr; 
        String lenMax = currentStr; 
    
        for (int i = k; i < s.length(); i++) { 
            currentStr = currentStr.substring(1, k) + s.charAt(i); 
            if (lenMax.compareTo(currentStr) < 0)      
                 lenMax = currentStr; 
            if (lenMin.compareTo(currentStr) > 0) 
                 lenMin = currentStr;             
        } 
  
        System.out.println(lenMin); 
        System.out.println(lenMax); 
    } 
  
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    { 
    	 System.out.println("Enter the String ");
         String str = scanner.nextLine(); 
         System.out.println("Enter the number of divison for String");
         int k = scanner.nextInt();
         getSmallestAndLargestSubString(str, k); 
    } 
}
