package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tarrif_master")
public class TarrifMaster implements Serializable {

	@Id
	@Column(name="rr_Number")
	private Integer rrNumber;
	
	@Column(name="type_of_consumer")
	private String typeOfConsumer;
	
	@Column(name="taxes")
	private Double taxes;
	
	@Column(name="units")
	private Double units;
}
