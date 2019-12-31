package com.bcits.jdbcapp.abstraction;

public class MainMethodProgram {
	public static void main(String[] args) {
		String dbUrl = "one";
		Connection con = DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement();
		
		stmt.method1();
	}

}
