package com.ty.bcits.algorithmanalysis;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort
{
	 public static void bubbleSort(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 0; i < n-1; i++) 
	            for (int j = 0; j < n-i-1; j++) 
	                if (arr[j] > arr[j+1]) 
	                {
	                    int temp = arr[j]; 
	                    arr[j] = arr[j+1]; 
	                    arr[j+1] = temp; 
	                } 
	    } 
	  
	    /* Prints the array */
	  public static  void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	  
	  public static void countDurationunsorted()
	   {
		  int arr[] = {2,3,47,9,0,1,7,10,11,12,54,34,56,756,78,43,56,978,12,456,67,43,68,345,78,345,788,34,68,96,4689,356,457,3457,899,422,7788,3445,7784,5668,34566,344,567,66767,445556,232232,55,345,55,66,445,33,1234,355,657,56,46,567,122};  
		   Instant start=Instant.now();
		    bubbleSort(arr);
		   Instant end=Instant.now();
		   Long duration=Duration.between(start, end).toMillis();
		   double seconds=duration/1000.0;
		   System.out.println("Sorted array"); 
	       printArray(arr);
	       System.out.println();
		   System.out.println(" bubbleSort unsortedarray took "+seconds+"seconds");     
	   }
	  
	  public static void countDurationsorted()
	   {
		  int arr[] = {0 ,1 ,2 ,3 ,7 ,9 ,10 ,11 ,12, 12, 33 ,34, 34, 43, 43, 46, 47 ,54 ,55, 55, 56 ,56 ,56, 66, 67, 68 ,68, 78 ,78, 96 ,122, 344 ,345, 345, 345 ,355 ,356 ,422, 445, 456 ,457 ,567, 567 ,657, 756 ,788 ,899, 978, 1234, 3445 ,3457, 4689 ,5668, 7784 ,7788 ,34566, 66767 ,232232, 445556 };  
		   Instant start=Instant.now();
		    bubbleSort(arr);
		   Instant end=Instant.now();
		   Long duration=Duration.between(start, end).toMillis();
		   double seconds=duration/1000.0;
		   System.out.println("Sorted array"); 
	       printArray(arr);
	       System.out.println();
		   System.out.println(" bubbleSort sortedarray took "+seconds+"seconds");     
	   }
	  
	 /* public static int reversearray(int a[])
	  {
		  int n=a.length;
		  int revarr[]= {0};
		  int k=0;
		  for(int i=n-1;i>=0;i--) {
			revarr[k]=revarr[k]+a[i];
		  }
		  //return revarr[];
	  }*/
	  
	  public static void countDurationReverse()
	   {
		  int arr[] = {0 ,1 ,2 ,3 ,7 ,9 ,10 ,11 ,12, 12, 33 ,34, 34, 43, 43, 46, 47 ,54 ,55, 55, 56 ,56 ,56, 66, 67, 68 ,68, 78 ,78, 96 ,122, 344 ,345, 345, 345 ,355 ,356 ,422, 445, 456 ,457 ,567, 567 ,657, 756 ,788 ,899, 978, 1234, 3445 ,3457, 4689 ,5668, 7784 ,7788 ,34566, 66767 ,232232, 445556};  
		   
		  Instant start=Instant.now();
		    bubbleSort(arr);
		   Instant end=Instant.now();
		   Long duration=Duration.between(start, end).toMillis();
		   double seconds=duration/1000.0;
		   System.out.println("Sorted array"); 
	       printArray(arr);
	       System.out.println();
		   System.out.println(" bubbleSort reversedarray took "+seconds+"seconds");     
	   }
	  
	  
	  public static void main(String args[]) 
	    { 
		  int arr[] = {0 ,1 ,2 ,3 ,7 ,9 ,10 ,11 ,12, 12, 33 ,34, 34, 43, 43, 46, 47 ,54 ,55, 55, 56 ,56 ,56, 66, 67, 68 ,68, 78 ,78, 96 ,122, 344 ,345, 345, 345 ,355 ,356 ,422, 445, 456 ,457 ,567, 567 ,657, 756 ,788 ,899, 978, 1234, 3445 ,3457, 4689 ,5668, 7784 ,7788 ,34566, 66767 ,232232, 445556};  
		  countDurationunsorted();
		  countDurationsorted();
		 // reversearray(arr);
		  countDurationReverse();
	   
	    } 
	} 
	  


