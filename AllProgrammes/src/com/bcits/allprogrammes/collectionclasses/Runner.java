package com.bcits.allprogrammes.collectionclasses;

import java.util.TreeSet;

public class Runner
{
public static void main(String[] args)
{
	 Mobile m1=new Mobile(30);
	 Mobile m2=new Mobile(40);
	 Mobile m3=new Mobile(10);
	 Mobile m4=new Mobile(20);                            
	 
	 TreeSet<Mobile> t1=new TreeSet<Mobile>();
	 t1.add(m1);
	 t1.add(m2);
	 t1.add(m3);
	 t1.add(m4);
	 for(Mobile m6:t1) {
	 System.out.println(m6);
}
}
}
