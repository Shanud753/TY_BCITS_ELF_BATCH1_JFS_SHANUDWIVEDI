package com.bcits.springrestjaxb.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.scenario.effect.Effect.AccelType;

import lombok.Data;

@Data
@XmlRootElement(name="user-other-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserOtherInfo {

	@XmlElement
	private String gender;
	@XmlElement(name="aadhar")
	private long aadharNo;
}
