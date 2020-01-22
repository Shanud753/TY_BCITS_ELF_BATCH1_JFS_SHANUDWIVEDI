package com.bcits.springcore;

import com.bcits.springcore.beans.EmployeeBean;

public class MyEMFFactory {
	private static EmployeeBean emf = null;
	
	// private cons
	
	public static EmployeeBean getEMFInstance() {
		if (emf == null) {
			emf = new EmployeeBean();
		}
		return emf;
	}

}
