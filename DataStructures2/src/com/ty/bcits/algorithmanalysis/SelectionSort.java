package com.ty.bcits.algorithmanalysis;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort {
	 public static void sort(int arr[]) 
	    { 
	        int n = arr.length; 
	  
	       
	        for (int i = 0; i < n-1; i++) 
	        { 
	           
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (arr[j] < arr[min_idx]) 
	                    min_idx = j; 
	  
	            int temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	        } 
	    } 
	  
	    // Prints the array 
	   public static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	  
	   public static void countDurationAddUpto()
	   {
		  int arr[] = {64, 34, 25, 12, 22, 11, 90, 1, 2, 4, 10, 33, 44, 55, 90, 100, 20, 31, 56, 20, 10, 29, 39, 101, 104, 500, 409, 6, 7, 9, 17 ,30, 107, 108, 109, 290, 209, 208, 100, 234, 451,17, 19,20,56,97,98,106, 55,50,62,64,29,24,28,29,41,44,57,56,53,39,18,42,48,95,92,91,93,99,211,256,231,254,27,26,74,79,54,52,51,3,0,465,27,24,36,62,24,21,5511,5444,6454,211,254,365,154,984,2541,75566,23545,41,22,87,92,952,235,24556,2155,48256,321,232566,2415,2146,351255,30565,87552,21456,321256,275,255,984,5412,77,123,354558,85456,752,34145,1155,26454,2456,21215,4562,4265,2335,22145,6620,23636,33652,126545}; 
		   Instant start=Instant.now();
		   sort(arr);
		   Instant end=Instant.now();
		   Long duration=Duration.between(start, end).toMillis();
		   double seconds=duration/1000.0;
		   System.out.println("Sorted array"); 
	       printArray(arr); 
	       System.out.println();
		   System.out.println(" selectionSort took "+seconds+"seconds"); 
		   
		    
	   }
	    public static void main(String args[]) 
	    { 
	    	countDurationAddUpto(); 
	 	    
	    } 
}
