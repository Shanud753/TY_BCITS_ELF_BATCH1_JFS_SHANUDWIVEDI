package com.pro;
import java.util.*;

public class Reverse2 
{
   public static void main(String[] args) {
	   
	Scanner s1=new Scanner(System.in);
	System.out.println("enter the string");
	String s2=s1.next();
	String s3=" ";
	char[] ch=s2.toCharArray();
	for(int i=ch.length-1;i>=0;i--)
	{
		s3=s3+ch[i];
	}
	System.out.println("before reversing:"+s2);
	System.out.println("after reversing:"+s3);
   }
   
}
