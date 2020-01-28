package com.bcits.springrestjaxb.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
@Data
@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeID","ename","designation"}) //to specify the order in which we want to display in json file
@XmlRootElement(name="Employee_info")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeInfoBean  {


	@JsonProperty("employeeID")
	@XmlElement(name="employee-id")
	private int empId;
	//@XmlElement
	@XmlAttribute(name="e-name")   //to make an element as an attribute
	private String ename;
	@XmlElement(name="mobile-no")
	private long mobileNo;
	@XmlElement
	private String officialMailid;
	@XmlElement
	private Date dob;
	@XmlElement
	private Date doj;
	@XmlElement
	private String designation;
	@XmlElement
	private String bldGrp;
	@XmlElement
	private double salary;
	@XmlElement(name="dept-id")
	private int deptId;
	@XmlElement
	private int mgrId;
//   @XmlTransient  //to avoid binding of the field to xml.
	@JsonIgnore  //to ignore this field
	@XmlElement
    private String password;
    
}
