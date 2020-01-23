package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;
import com.bcits.springcoreannotations.config.EmployeeConfig2;

public class EmployeeTest2 {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig2.class);
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);

		System.out.println("Emp Name : "+ employeeBean.getName());
		System.out.println("Emp Age : "+ employeeBean.getAge());
		System.out.println("Dept Name : "+ employeeBean.getDepartmentBean().getDeptName());
		System.out.println("Dept ID : "+ employeeBean.getDepartmentBean().getDeptId());

	}//End of main()
}//End of Class
