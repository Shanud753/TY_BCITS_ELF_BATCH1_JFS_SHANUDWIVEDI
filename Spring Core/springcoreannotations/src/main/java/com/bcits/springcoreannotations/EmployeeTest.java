package com.bcits.springcoreannotations;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;

public class EmployeeTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		//Close the Container to get Destruction phase
		((ConfigurableApplicationContext)context).registerShutdownHook();
		
		EmployeeBean employeeBean1 = context.getBean(EmployeeBean.class);
		System.out.print("Enter Employee-1 Name : ");
		employeeBean1.setName(scanner.nextLine());
		System.out.print("Enter Employee-1 Age : ");
		employeeBean1.setAge(scanner.nextInt());
		scanner.nextLine();  //to go to next object
		
		EmployeeBean employeeBean2 = context.getBean(EmployeeBean.class);
		System.out.print("Enter Employee-2 Name : ");
		employeeBean2.setName(scanner.nextLine());
		System.out.print("Enter Employee-2 Age : ");
		employeeBean2.setAge(scanner.nextInt());
		
		System.out.println("Employee Name = "+ employeeBean1.getName());
		System.out.println("Employee Age = "+ employeeBean1.getAge());
		System.out.println("Employee Name = "+ employeeBean2.getName());
		System.out.println("Employee Age = "+ employeeBean2.getAge());

		
	}//End of main()
}//End of Class
