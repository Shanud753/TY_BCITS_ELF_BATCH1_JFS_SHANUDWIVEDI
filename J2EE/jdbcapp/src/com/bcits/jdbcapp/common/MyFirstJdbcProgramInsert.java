package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJdbcProgramInsert {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			// 1.LOAD the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// 2.Get the DB connection via Driver

			String dburl = "jdbc:mysql://localhost:3306/Employee_management_info";
			//DriverManager driverManager= new DriverManager ();
			con= DriverManager.getConnection(dburl,"root","root");

			// 3.Issue the Sql queries via Connection
			String query = " insert into employee_primary_info "
					+ " values(12,'hanu',8564876543,'shanu1@gmail.com','1997-10-28','2019-02-24',"
					+ " 'Software Dveloper','a+',90000,30,3)";
			stmt = con.createStatement();
			int i = stmt.executeUpdate(query);

			// 4.Process the result returned by Sql Queries
			System.out.println("count value is==>" + i);
			System.out.println("Record Inserted");

			// 5.Close all jdbc Objects
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
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
