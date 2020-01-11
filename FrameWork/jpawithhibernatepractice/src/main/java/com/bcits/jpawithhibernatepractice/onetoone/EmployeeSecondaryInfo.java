package com.bcits.jpawithhibernatepractice.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

@Entity
@Table(name="employee_secondary_info")
public class EmployeeSecondaryInfo implements Serializable{
	@Id
	private int empid;
	@Column
	private String personalMailId;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private String nationality;
	@Column
	private String isMarried;
	@Column
	private String govtId;
	@Column
	private String gurdianName;
	@Column
	private long gurdianContactNo;
	@Column
	private String jobLocation;
	
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeePrimaryInfo primaryInfo;
	public EmployeePrimaryInfo getPrimaryInfo() {
		return primaryInfo;
	}
	public void setPrimaryInfo(EmployeePrimaryInfo primaryInfo) {
		this.primaryInfo = primaryInfo;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getPersonalMailId() {
		return personalMailId;
	}
	public void setPersonalMailId(String personalMailId) {
		this.personalMailId = personalMailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}
	public String getGovtId() {
		return govtId;
	}
	public void setGovtId(String govtId) {
		this.govtId = govtId;
	}
	public String getGurdianName() {
		return gurdianName;
	}
	public void setGurdianName(String gurdianName) {
		this.gurdianName = gurdianName;
	}
	public long getGurdianContactNo() {
		return gurdianContactNo;
	}
	public void setGurdianContactNo(long gurdianContactNo) {
		this.gurdianContactNo = gurdianContactNo;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}






}
