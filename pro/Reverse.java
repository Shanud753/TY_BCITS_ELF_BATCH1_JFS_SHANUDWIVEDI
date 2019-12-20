package com.pro;
import java.util.*;

public class Reverse 
{
   public static void main(String[] args) {
	   
	String s="JAVA";
	String s1=" ";
	char[] ch=s.toCharArray();
	for(int i=ch.length-1;i>=0;i--)
	{
		s1=s1+ch[i];
	}
	System.out.println("before reversing:"+s);
	System.out.println("after reversing:"+s1);
   }
   
}
