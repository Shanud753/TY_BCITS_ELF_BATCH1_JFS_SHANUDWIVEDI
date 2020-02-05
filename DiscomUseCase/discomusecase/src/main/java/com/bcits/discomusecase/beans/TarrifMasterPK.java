package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TarrifMasterPK implements Serializable {

	@Column
	private String type;
	@Column
	private long range;
}
