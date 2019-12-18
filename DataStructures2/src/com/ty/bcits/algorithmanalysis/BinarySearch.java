package com.ty.bcits.algorithmanalysis;

public class BinarySearch
{
    void bSearch(int[] a,int n,int key)
    {
    	int low=0;
    	int mid;
    	int high=n-1;
    	int pos=0;
    	int flag=0;
    	while(low<=high)
    	{
    		mid=(low+high)/2;
    		if(key==a[mid])
    		{
    			flag=1;
    			pos=mid;
    			System.out.println("element found at pos: "+(pos+1));
    			break;
    		}
    		else if(key>a[mid])
    		{
    			low=mid+1;
    		}
    		else
    		{
    			high=mid-1;
    		}
    	}
    	if(flag==0)
    	{
    		System.out.println("element not found");	
    	}
    	
    }
}
