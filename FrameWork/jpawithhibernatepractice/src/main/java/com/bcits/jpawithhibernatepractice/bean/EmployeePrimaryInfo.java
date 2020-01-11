package com.bcits.jpawithhibernatepractice.bean;

import java.io.Serializable;
import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
	private String official_mailid;
    @Column
	private Date dob;
    @Column
	private Date doj;
    @Column
	private String designation;
    @Column
	private String bld_grp;
    @Column
	private double salary;
    @Column
	private int depId;
    @Column
	private int mrgId;
	
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
	public String getOfficial_mailid() {
		return official_mailid;
	}
	public void setOfficial_mailid(String official_mailid) {
		this.official_mailid = official_mailid;
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
	public String getBld_grp() {
		return bld_grp;
	}
	public void setBld_grp(String bld_grp) {
		this.bld_grp = bld_grp;
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
