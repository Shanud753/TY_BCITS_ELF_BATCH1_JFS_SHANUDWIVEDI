package com.bcits.collectioninterface.Set;

import java.util.HashSet;

public class HashSet1
{
  public static void main(String[] args) 
  {
	  HashSet<Integer> h1=new HashSet<Integer>();
	  h1.add(12);
	  h1.add(30);
	  h1.add(2);
	  h1.add(45);
	  
	  System.out.println(h1);
	  
	  h1.remove(2);
	  System.out.println(h1);
	  h1.remove(30);
	  System.out.println(h1);
	  
	  h1.add(null);
	  System.out.println(h1);
	
}
}
