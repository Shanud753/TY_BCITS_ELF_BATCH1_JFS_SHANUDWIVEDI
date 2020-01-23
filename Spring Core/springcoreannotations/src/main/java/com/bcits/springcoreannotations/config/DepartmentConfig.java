package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.DepartmentBean;

@Configuration
public class DepartmentConfig {

	@Bean(name="dev")
	public DepartmentBean getDepartmentDev() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptName("Dev");
		departmentBean.setDeptId(11);
		
		return departmentBean;
	}//End of getDepartmentDev()
	
	@Bean(name="Hr")
//	@Primary
	public DepartmentBean getDepartmentHr() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptName("HR");
		departmentBean.setDeptId(12);
		
		return departmentBean;
	}//End of getDepartmentHr()
	
	@Bean(name="acc")
	public DepartmentBean getDepartmentAccount() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptName("Account");
		departmentBean.setDeptId(13);
		
		return departmentBean;
	}//End of getDepartmentAccount()
}
