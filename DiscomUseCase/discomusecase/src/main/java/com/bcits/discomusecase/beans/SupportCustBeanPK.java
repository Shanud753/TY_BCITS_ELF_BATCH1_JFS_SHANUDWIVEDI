package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SupportCustBeanPK implements Serializable {
	@Column(name="rr_number")
	private Integer rrNumber;
	@Column
	private Date date;
}
