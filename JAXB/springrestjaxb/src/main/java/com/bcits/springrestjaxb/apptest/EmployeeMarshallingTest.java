package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshallingTest {

	public static void main(String[] args) {
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		employeeInfoBean.setEmpId(1234);
		employeeInfoBean.setDeptId(22);
		employeeInfoBean.setDesignation("SSD");
		employeeInfoBean.setDob(new Date());
		employeeInfoBean.setDoj(new Date());
		employeeInfoBean.setEname("Shanu");
		employeeInfoBean.setBldGrp("AB+");
		employeeInfoBean.setMgrId(0);
		employeeInfoBean.setOfficialMailid("shanu@email.com");
		employeeInfoBean.setSalary(98765);
		employeeInfoBean.setMobileNo(9876543214l);
		employeeInfoBean.setPassword("qwerty");
		
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfoBean.class);  //This binds Class to XML
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  //Result displayed in XML is Formatted
			marshaller.marshal(employeeInfoBean, System.out); //To display on console
			marshaller.marshal(employeeInfoBean, new File("employeeInfo.xml"));
			} catch (JAXBException e) {
			e.printStackTrace();
			System.err.println("\n\nUnable to Marshal!!!");
		} 
	}
}
