package com.pro;

public class MainClassPro
{
	public static void main(String[] args)
	{
		Product p1=new Product();
		p1.setCost(1000);
		p1.setBrand("polo");
		
		Product p2=new Product();
		p2.setCost(2000);
		p2.setBrand("titan");
		
		Product p3=new Product();
		p3.setCost(3000);
		p3.setBrand("rado");
		
		Product p4=new Product();
		p4.setCost(4000);
		p4.setBrand("fastrack");
		
		Product p[]= {p1,p2,p3,p4};
		for(int i=0;i<p.length;i++)
		{
			System.out.println(p[i].getCost()+","+p[i].getBrand());
		}
		
	}

}
