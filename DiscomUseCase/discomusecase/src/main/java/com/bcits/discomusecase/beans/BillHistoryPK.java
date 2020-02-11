package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Data
@Embeddable
public class BillHistoryPK implements Serializable{
	@Column(name="rr_number")
	private int rrNumber;
	@Column
	private Date PayDate;
}
