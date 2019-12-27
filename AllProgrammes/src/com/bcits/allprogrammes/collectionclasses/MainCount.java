package com.bcits.allprogrammes.collectionclasses;

public class MainCount 
{
public static void main(String[] args) {
	CountObject c=new CountObject(21, "ram");
	CountObject c1=new CountObject(22, "shyam");
	CountObject c2=new CountObject(23, "gham");
	CountObject c3=new CountObject(24, "dham");
	CountObject c4[]= {c,c1,c2,c3};
	int count=0;
	for(int i=0;i<c4.length;i++)
	{
		count++;
	}
	
	System.out.println("total objects are:"+count);
}
}
