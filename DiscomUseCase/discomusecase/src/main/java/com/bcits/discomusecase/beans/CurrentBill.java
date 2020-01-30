package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//@Entity
@Table(name="current_bill")
public class CurrentBill implements Serializable{

	 @Column(name="rr_number")
	 private Integer rrNumber;
	 
	 @Column(name="initial_Date")
	 private Date initialDate;
	 
	 @Column(name="final_Date")
	 private Date finalDate;
	 
	 @Column(name="initial_reading")
	 private Double initialReading;
	 
	 @Column(name="final_reading")
	 private Double finalReading;
	 
	 @Column(name="units_consumption")
	 private Double unitsConsumption;
	 
}
