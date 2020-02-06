package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="consumers_master_info")
public class ConsumersMaster implements Serializable {
	@Id
	@Column(name="rr_number")
	private Integer rrNumber;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column
	private String email;
	
	@Column(name="mobile_Number")
	private long phnNo;
	
	@Column
	private String password;
	
	@Column(name="confirm_password")
	private String confirmPassword;
	
	@Column
	private String region;
	
	@Column(name="type_of_consumer")
	private String typeOfConsumer;
	
	@Column(name="address_Line1")
	private String addressLine1;
	
	@Column(name="address_Line2")
	private String addressLine2;
	@Column
	private String city;
	
	@Column(name="meter_number")
	private long meterNumber;
	
	@Column(name="date_of_connection")
	private Date dateOfConnection;
	

}
