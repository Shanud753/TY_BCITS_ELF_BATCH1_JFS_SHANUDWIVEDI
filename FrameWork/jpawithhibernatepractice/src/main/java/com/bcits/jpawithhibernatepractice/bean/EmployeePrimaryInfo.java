package com.bcits.jpawithhibernatepractice.bean;

import java.io.Serializable;

import java.sql.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernatepractice.manytomany.ProjectInfo;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernatepractice.onetoone.EmployeeSecondaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;

@Entity
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
	@Id
    @Column
	private int eid;
    @Column
	private String ename;
    @Column
	private long mobile_no;
    @Column
	private String officialMailid;
    @Column
	private Date dob;
    @Column
	private Date doj;
    @Column
	private String designation;
    @Column
	private String bldGrp;
    @Column
	private double salary;
    @Column
	private int depId;
    @Column
	private int mrgId;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "primaryInfo")
    private EmployeeSecondaryInfo secondaryInfo;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "primaryInfo")
    private List<EmployeeAddressInfo> address;
    
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "primaryInfo")
    private List<ProjectInfo> projectInfos;
    
    public List<EmployeeAddressInfo> getAddress() {
		return address;
	}
	public void setAddress(List<EmployeeAddressInfo> address) {
		this.address = address;
	}
	
	
	public EmployeeSecondaryInfo getSecondaryInfo() {
		return secondaryInfo;
	}
	public void setSecondaryInfo(EmployeeSecondaryInfo secondaryInfo) {
		this.secondaryInfo = secondaryInfo;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	public String getOfficialMailid() {
		return officialMailid;
	}
	public void setOfficialMailid(String officialMailid) {
		this.officialMailid = officialMailid;
	}
	public String getBldGrp() {
		return bldGrp;
	}
	public void setBldGrp(String bldGrp) {
		this.bldGrp = bldGrp;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public int getMrgId() {
		return mrgId;
	}
	public void setMrgId(int mrgId) {
		this.mrgId = mrgId;
	}
	
	
}
