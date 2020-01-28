package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONUnMarshalling {

	
	public static void main(String[] args) {
		
		//UnMarshalling from JSON to java object
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			EmployeeInfoBean employeeInfoBean = objectMapper.readValue(new File("empJson5.json"), EmployeeInfoBean.class);
			System.out.println(employeeInfoBean);
//			System.out.println("Emp Id   : "+ employeeInfoBean.getEmpId());
//			System.out.println("Emp Name : "+ employeeInfoBean.getEname());
//			System.out.println("Salary   : "+ employeeInfoBean.getSalary());
//			System.out.println("DOB      : "+ employeeInfoBean.getDob());
//			System.out.println("Password : "+ employeeInfoBean.getPassword());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//End of main()
}//End of Class
