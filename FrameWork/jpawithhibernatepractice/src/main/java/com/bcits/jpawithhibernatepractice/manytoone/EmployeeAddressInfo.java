package com.bcits.jpawithhibernatepractice.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="employee_address_info")
public class EmployeeAddressInfo implements Serializable {
	
	    @EmbeddedId
	    private EmployeeAddressPK addressPK;
	    @Column
		private int houseNo;
	    @Column
		private String address1;
	    @Column
		private String address2;
	    @Column
		private String landMark;
	    @Column
		private String city;
	    @Column
		private long pinCode;
		
	    @MapsId("eid")
	    @ManyToOne(cascade =CascadeType.ALL )
	    @JoinColumn(name="empid")
	    private EmployeePrimaryInfo primaryInfo;

}
