package com.bcits.jpawithhibernatepractice.manytoone;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeEducationInfo implements Serializable {
	
	@EmbeddedId
	private EmployeeEducationPK educationPk;
	@Column
	private String collegeName;
	@Column
	private Date yop;
	@Column
	private String stream;
	@Column
	private double percentage;
	@Column
	private String universityName;
	
	    @MapsId("eid")
	    @ManyToOne(cascade =CascadeType.ALL )
	    @JoinColumn(name="empid")
	    private EmployeePrimaryInfo primaryInfo;
}
