package com.pro;
import java.util.*;
public class Reverse3
{
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	System.out.println("enter the string");
	String s2=s1.next();
	char[] ch=s2.toCharArray();
	System.out.println(s2);
	int i,j;
	int len=0;
	for(;ch[++len]!='\0';);
	System.out.println("length:"+len);
	i=0;
	j=len-1;
	while(i<j)
	{
		if(i%2!=0) {
			ch[i]=(char) (ch[i] + ch[j]);
			ch[j]=(char) (ch[i] - ch[j]);
			ch[i]=(char) (ch[i] - ch[j]);
			i++;
			j--;
			
			
		}
		System.out.println(ch);
	}
	
}
}
