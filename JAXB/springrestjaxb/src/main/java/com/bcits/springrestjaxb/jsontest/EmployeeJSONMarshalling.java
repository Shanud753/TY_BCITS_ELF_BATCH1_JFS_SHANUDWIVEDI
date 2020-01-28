package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONMarshalling {
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
		employeeInfoBean.setMobileNo(8746543214l);
		employeeInfoBean.setPassword("qwerty");
		
		//Marshalling into JSON
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter(); //Formatted JSON Object
			mapper.writeValue(new File("empJson5.json"), employeeInfoBean);
			mapper.writeValue(System.out, employeeInfoBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		
		}//End of main()
}//End of Class
