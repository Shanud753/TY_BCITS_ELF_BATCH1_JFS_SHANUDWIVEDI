package com.ty.bcits.algorithmanalysis;

public class LinearSearch 
{
    void search(int a[],int n,int key)
    {
    	int flag=0,pos=0;
    	for(int i=0;i<n;i++)
    	{
    		if(key==a[i]) {
    		    flag=1;
    			pos=i;
    			System.out.println("element found at positon:"+(pos+1));
    			
    		}
    	}
    	if(flag==0)
		{
			System.out.println("element not found");
		}
  
    }
}
