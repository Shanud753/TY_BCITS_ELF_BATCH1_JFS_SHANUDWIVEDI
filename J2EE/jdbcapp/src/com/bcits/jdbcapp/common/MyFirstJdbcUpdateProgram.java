package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJdbcUpdateProgram {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String url = "jdbc:mysql://localhost:3306/Employee_management_info";
			con = DriverManager.getConnection(url, "root", "root");

			String query = "update employee_primary_info set empname='meena' where empid=4 ";
			stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);

			System.out.println("No of rows affected==>" + rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
