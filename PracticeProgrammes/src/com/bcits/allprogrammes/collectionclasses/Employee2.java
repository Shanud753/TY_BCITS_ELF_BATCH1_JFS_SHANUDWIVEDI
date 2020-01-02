package com.bcits.allprogrammes.collectionclasses;

import java.util.*;
public class Employee2 
{

	String ename;
    int eid;
    int salary;
    
	public Employee2(String ename, int eid,int salary) {
	
		this.ename = ename;
		this.eid = eid;
		this.salary = salary;
	}

@Override
public String toString() {
	return "Employee2 [ename=" + ename + ", eid=" + eid + ", salary=" + salary + "]";
}



   
}
