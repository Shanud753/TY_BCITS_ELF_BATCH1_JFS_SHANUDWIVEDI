package com.bcits.jpawithhibernatepractice.manytoone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmployeeEducationPK implements Serializable{
	@Column
	private int eid;
	@Column
	private String educationType;
}
