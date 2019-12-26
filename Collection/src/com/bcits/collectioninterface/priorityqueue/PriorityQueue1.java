package com.bcits.collectioninterface.priorityqueue;
import java.util.*;
public class PriorityQueue1 
{
public static void main(String[] args)
{
	PriorityQueue<Integer> p1=new PriorityQueue<Integer>();
	p1.add(87);
	p1.add(45);
	p1.add(12);
	p1.add(69);
	p1.add(2);
	p1.add(98);
	
	System.out.println(p1); 
	p1.remove();  //priority is given to the least element in the queue
	System.out.println(p1);
	p1.remove();
	System.out.println(p1);
	
	//p1.add(null);//gives null pointer exception
	p1.add(2);
	System.out.println(p1);
	
}
}
