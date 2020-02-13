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
@Table(name="current_bill")
public class CurrentBill implements Serializable{

	@Id
	@Column(name="rr_number")
	private String rrNumber;
	
	@Column(name="due_date")
	private Date dueDate;

	
	@Column(name="initial_reading")
	private double initialReading;
	
	@Column(name="final_reading")
	private double finalReading;
	
	@Column(name="units_consumed")
	private double unitsConsumed;
	
	 @Column(name="bill_amount")
	 private double billAmount;
	 
	 @Column(name="type_of_consumer")
	 private String typeOfConsumer;
	 @Column
	 private String region;
	 @Column(name = "statement_date")
	private Date statementDate;
	 @Column
	 private String status;
}
