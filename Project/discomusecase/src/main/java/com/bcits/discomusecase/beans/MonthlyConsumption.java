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
@Table(name="monthly_consumption")
public class MonthlyConsumption implements Serializable {
   @Id
   @Column(name="initial_Date")
   private Date initialDate;
   @Column(name="final_Date")
   private Date finalDate;
   @Column(name="initial_Date")
   private double unitsConsumption;
}
