package com.bcits.springmvc.customexceptions;

public class EmployeeException extends RuntimeException {

	public EmployeeException(String message) {
		super(message);
	}
}
