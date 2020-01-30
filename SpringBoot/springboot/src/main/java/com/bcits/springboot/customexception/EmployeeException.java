package com.bcits.springboot.customexception;

public class EmployeeException extends RuntimeException {

	public EmployeeException(String message) {
		super(message);
	}
}
