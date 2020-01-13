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
@Table(name="employee_bank_info")
public class EmployeeBankInfo implements Serializable {
	@Id
	private int empid;
	@Column(name="Account_no")
	private long AccountNo;
	@Column(name="Bank_name")
	private String BankName;
	@Column(name="Branch_name")
	private String BranchName;
	@Column(name="IFSC_code")
	private String ifscCode;
	
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
	public long getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(long accountNo) {
		AccountNo = accountNo;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
