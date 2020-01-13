package com.bcits.hackerrank.strings;

import java.util.Arrays;
import java.util.Scanner;

public class AnaGram {
	static boolean isAnagram(char[] str1, char[] str2) 
    { 
        int n1 = str1.length; 
        int n2 = str2.length; 
  
        if (n1 != n2) {
            return false;
        }
        
        Arrays.sort(str1); 
        Arrays.sort(str2); 
   
        for (int i = 0; i < n1; i++) 
            if (str1[i] != str2[i]) {
                return false; 
            }
  
        return true; 
    }

static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
	System.out.println("Enter the 1st String ");
	char[] str1 = scanner. next().toCharArray();
	System.out.println("Enter the 2nd String");
	char[] str2 =scanner. next().toCharArray();
	
	if(isAnagram(str1,str2)) {
		System.out.println("Anagrams");
	}
	else {
		System.out.println("Not Anagrams");
	}
	
}
}