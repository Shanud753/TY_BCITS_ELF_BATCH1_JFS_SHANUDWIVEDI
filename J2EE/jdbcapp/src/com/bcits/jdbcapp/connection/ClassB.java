package com.bcits.jdbcapp.connection;

public class ClassB implements Connection {

	@Override
	public void print() {
		System.out.println("BBBBBBBBBBBB");

	}
	/*
	 * SHOULD provide different implementation for all 10 Abstract Methods
	 */
}// End of ClassB
