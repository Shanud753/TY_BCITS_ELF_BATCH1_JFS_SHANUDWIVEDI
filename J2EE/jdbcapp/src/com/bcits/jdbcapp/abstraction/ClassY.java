package com.bcits.jdbcapp.abstraction;

public class ClassY implements Connection {

	@Override
	public Statement createStatement() {
		
		return new ClassA();
	}
	/*
	 * provides implementation for all
	 * abstract methods present in Interface
	 */
}
