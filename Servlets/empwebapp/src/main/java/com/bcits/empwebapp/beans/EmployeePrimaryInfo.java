package com.bcits.empwebapp.beans;

import java.io.Serializable;

import java.sql.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
	
	@Id
    @Column(name="emp_id")
	private int empId;
	
    @Column
	private String ename;
    
    @Column(name="mobile")
	private long mobileNo;
    
    @Column(name="official_mail_id")
	private String officialMailid;
    
    @Column(name="date_of_birth")
	private Date dob;
    
    @Column(name="date_of_joining")
	private Date doj;
    
    @Column
	private String designation;
    
    @Column(name="bld_grp")
	private String bldGrp;
    
    @Column
	private double salary;
    
    @Column(name="department_id")
	private int depId;
    
    @Column(name="manager_id")
	private int mrgId;
    
    @Column
    private String password;
    
    




	
	
}
