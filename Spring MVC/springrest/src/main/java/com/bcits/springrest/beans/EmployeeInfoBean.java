package com.bcits.springrest.beans;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
//@XmlRootElement(name="employee-info")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeId","ename","designation"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeInfoBean  {


//	@XmlElement(name="empId")
	@JsonProperty("employeeId")
	@Id
    @Column(name="emp_id")
	private Integer empId;
	
    @Column
	private String ename;
    
    @Column(name="mobile")
	private Long mobileNo;
    
    @Column(name="official_mail_id")
	private String officialMailid;
    
    @Column(name="date_of_birth")
//    @DateTimeFormat(iso = ISO.DATE)
	private Date dob;
    
    @Column(name="date_of_joining")
//    @DateTimeFormat(iso=ISO.DATE)
	private Date doj;
    
    @Column
	private String designation;
    
    @Column(name="bld_grp")
	private String bldGrp;
    
    @Column
	private Double salary;
    
    @Column(name="department_id")
	private Integer depId;
    
    @Column(name="manager_id")
	private Integer mrgId;
    
    @Column
    private String password;
    
}
