package com.bcits.discomusecase.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin_info")
public class AdminInfo {
	@Id
	@Column
	private String username;
	@Column
	private String name;
	@Column
	private String password;	
}
