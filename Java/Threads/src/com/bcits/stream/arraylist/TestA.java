package com.bcits.stream.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestA {
public static void main(String[] args) {
	ArrayList<Integer> a1=new ArrayList<Integer>();
	a1.add(20);
	a1.add(36);
	a1.add(47);
	a1.add(35);
	a1.add(39);
	
	System.out.println(a1);
	
	System.out.println("*****************modify the result through map()*************************");
	List l1=a1.stream().map(i -> i*2).collect(Collectors.toList());
	for(Object obj:l1)
	{
		System.out.println(obj);
	}
	
	System.out.println("*****************Filter out the result*************************");
	
	List l2=a1.stream().filter(i -> i%2==0).collect(Collectors.toList());
	
	for(Object obj:l2)
	{
		System.out.println(obj);
	}
}
}
