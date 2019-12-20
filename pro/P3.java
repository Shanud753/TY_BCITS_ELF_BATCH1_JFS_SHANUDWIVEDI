package com.pattern;
import java.util.*;
public class P3
{
      public static void main(String[] args)
      {
    	  Scanner s1=new Scanner(System.in);
    	  System.out.println("enter n value");
    	  int n=s1.nextInt();
    	  int i,j;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    	  
		
    	  for(i=1;i<=n;i++)
    	  {
    	
    		  for(j=1;j<=n;j++)
    		  {
    			  if(j+i>=n+1)
    			  {
    				  System.out.print("*");
    			  }
    		  }
    		 System.out.print("\n");
    	  }
	}
}
