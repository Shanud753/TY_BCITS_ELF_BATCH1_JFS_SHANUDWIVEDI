package com.bcits.allprogrammes.patterns;
import java.util.*;
public class P8
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
    			  if(i==(n/2)+1 || j==(n/2)+1)
    				  System.out.print("*");
    			  else
    				  System.out.print(" ");
    			  
    		  }
    		 System.out.print("\n");
    		  
    	  }
	}
}
