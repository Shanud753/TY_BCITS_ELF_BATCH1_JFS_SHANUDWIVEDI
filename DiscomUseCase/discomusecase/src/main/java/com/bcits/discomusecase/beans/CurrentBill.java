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
	private Integer rrNumber;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="meter_number")
	private Long meterNumber;
	
	@Column(name="initial_reading")
	private Double initialReading;
	
	@Column(name="final_reading")
	private Double finalReading;
	
	@Column(name="units_consumed")
	private Double unitsConsumed;
	
	 @Column(name="bill_amount")
	 private Double billAmount;
	 
	 @Column(name="type_of_consumer")
	 private String typeOfConsumer;
	
	 
}
