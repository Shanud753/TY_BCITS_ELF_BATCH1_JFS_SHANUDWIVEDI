package com.bcits.jdbcapp.abstraction;

public class DriverManager {
	private DriverManager() {
	}

	public static Connection getConnection(String dburl) {
		Connection con = null;
		if (dburl.equals("one")) {
			con = new ClassX();
		} else {
			con = new ClassY();
		}
		return con;
	}//End of getConnection
	
}//End of Class
