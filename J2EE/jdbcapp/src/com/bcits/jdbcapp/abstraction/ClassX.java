package com.bcits.jdbcapp.abstraction;

public class ClassX implements Connection {

	@Override
	public Statement createStatement() {
		
		//return new ClassA();
		return new ClassC();
	}
	/*
	 * provides implementation for all
	 * abstract methods present in Interface
	 */

}
