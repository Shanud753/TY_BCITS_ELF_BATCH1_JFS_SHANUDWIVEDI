package com.pro;


public class Mainclass 
{
  public static void main(String[] args)
  {
	  Studenta s1=new Studenta();
		s1.setId(1);
		s1.setName("abc");
		Studenta s2=new Studenta();
		s2.setId(2);
		s2.setName("def");
		Studenta s3=new Studenta();
		s3.setId(3);
		s3.setName("ghi");
		Studenta s4=new Studenta();
		s4.setId(4);
		s4.setName("jkl");
		Studenta stud[] = {s1,s2,s3,s4};
		for(int i=0;i<stud.length;i++)
		{
			System.out.println("id is:"+stud[i].getId()+" & name is:"+stud[i].getName());
		}
}

}
