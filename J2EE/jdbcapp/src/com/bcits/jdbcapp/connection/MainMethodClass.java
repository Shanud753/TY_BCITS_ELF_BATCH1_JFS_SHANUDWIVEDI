package com.bcits.jdbcapp.connection;

public class MainMethodClass {

	public static void main(String[] args) {
		
		String str="one";
		Connection con=DriverManager.getConnection(str); //DriverManager is a helper Class
		con.toString();
		con.print();
	}//End of Main
}//End of Class
