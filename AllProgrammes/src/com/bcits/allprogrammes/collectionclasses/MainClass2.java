package com.bcits.allprogrammes.collectionclasses;

import java.util.ArrayList;

public class MainClass2 
{
  public static void main(String[] args) {
	
	  Product p1=new Product();
	  p1.setCost(100);
	  p1.setBrand("audi");
	  
	  Product p2=new Product();
	  p2.setCost(200);
	  p2.setBrand("ferrari");
	  
	  Product p3=new Product();
	  p3.setCost(300);
	  p3.setBrand("bmw");
	  
	  Product p4=new Product();
	  p4.setCost(400);
	  p4.setBrand("ford");
	  
	  Product p5=new Product();
	  p5.setCost(500);
	  p5.setBrand("dzire");
	  
	  ArrayList<Product> a=new ArrayList();
	  a.add(p1);
	  a.add(p2);
	  a.add(p3);
	  a.add(p4);
	  a.add(p5);
	  
	  for(Product p:a)
	  {
		  System.out.println(p);
	  }
}
}
