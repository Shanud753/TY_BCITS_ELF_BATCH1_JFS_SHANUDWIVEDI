package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name = "query_info")
public class SupportCustBean implements  Serializable{
	@EmbeddedId
	private SupportCustBeanPK supportBeanCustPK; 
	private String request;
	private String response;
	private String region;
}
