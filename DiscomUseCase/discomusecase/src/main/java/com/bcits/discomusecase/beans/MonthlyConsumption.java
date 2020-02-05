package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="monthly_consumption")
public class MonthlyConsumption implements Serializable {
    
	 @EmbeddedId
	 private MonthlyConsumptionPK consumptionPk;
   
     @Column(name="units_consumed")
     private double unitsConsumed;
   
     @Column(name="bill_amount")
     private double billAmount;
   
     @Column(name="initial_reading")
	  private double initialReading; 
	
     @Column(name="final_reading")
	  private double finalReading;
     
     @Column
     private String status;
   
  
}
