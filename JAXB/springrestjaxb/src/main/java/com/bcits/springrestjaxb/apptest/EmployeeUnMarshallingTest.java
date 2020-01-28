package com.bcits.springrestjaxb.apptest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnMarshallingTest {
	public static void main(String[] args) {

		JAXBContext jaxbContext;
		try {
			jaxbContext =  JAXBContext.newInstance(EmployeeInfoBean.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			EmployeeInfoBean employeeInfoBean =(EmployeeInfoBean) unmarshaller.unmarshal(new File("employeeInfo2.xml"));

			System.out.println("Emp Id   : "+ employeeInfoBean.getEmpId());
			System.out.println("Emp Name : "+ employeeInfoBean.getEname());
			System.out.println("Salary   : "+ employeeInfoBean.getSalary());
			System.out.println("DOB      : "+ employeeInfoBean.getDob());
			System.out.println("DOJ      : "+ employeeInfoBean.getDoj());
		}catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}