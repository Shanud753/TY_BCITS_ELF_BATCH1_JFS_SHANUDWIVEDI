package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeBeanTest {
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	
	
	//Created Only Once
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	EmployeeBean employeeBean = (EmployeeBean) context.getBean("employee");
	
	System.out.println("Enter Employee Name: ");
	employeeBean.setName(scanner.nextLine());
	System.out.println("Enter Employee Age: ");
	employeeBean.setAge(scanner.nextInt());
	scanner.nextLine();
	
	EmployeeBean employeeBean2 = (EmployeeBean) context.getBean("employee");
	System.out.println("Enter Employee Name: ");
	employeeBean2.setName(scanner.nextLine());
	System.out.println("Enter Employee Age: ");
	employeeBean2.setAge(scanner.nextInt());
	scanner.nextLine();
	
	
	
	System.out.println("Name:"+employeeBean.getName());
	System.out.println("Age:"+employeeBean.getAge());
	System.out.println("Name:"+employeeBean2.getName());
	System.out.println("Age:"+employeeBean2.getAge());
	
//	EmployeeBean employeeBean1 = (EmployeeBean) context.getBean("employee2");
//	System.out.println("Name:"+employeeBean1.getName());
//	System.out.println("Age:"+employeeBean1.getAge());
}
}