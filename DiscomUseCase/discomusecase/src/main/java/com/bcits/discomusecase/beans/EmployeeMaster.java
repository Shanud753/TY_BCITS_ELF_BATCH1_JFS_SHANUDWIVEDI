package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee_login_info")
public class EmployeeMaster implements Serializable{
	@Id
	@Column(name="emp_Id")
	private int empId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="emp_Name")
	private String empName;
	
	@Column(name="region")
	private String region;

}
