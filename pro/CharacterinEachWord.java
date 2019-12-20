package com.pro;
import java.util.*;
public class CharacterinEachWord 
{
  static void count(String str)
  {
	  char[] ch=str.toCharArray();
	  for(int i=0;i<ch.length;i++) {
		  String s="";
		  while(i<ch.length && ch[i]!=' ') {
			  s=s+ch[i];
			  i++;
		  }
		  if(s.length()>0)
			  System.out.print(s+s.length()+" ");
	  }
  }
  public static void main(String[] args) 
  {
	//Scanner sc1=new Scanner(System.in);
	//System.out.println("enter the string");
	//String s=sc1.next();
	  String s="hi my dear friends";
	count(s);
}
}
