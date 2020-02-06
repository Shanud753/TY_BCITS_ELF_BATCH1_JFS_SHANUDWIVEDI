package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="bill_History")
public class BillHistory implements Serializable {

    @EmbeddedId
	private BillHistoryPK billHistoryPk;
    
    @Column(name="bill_amount")
	 private double billAmount;
    
    @Column
    private String status;
    
}
