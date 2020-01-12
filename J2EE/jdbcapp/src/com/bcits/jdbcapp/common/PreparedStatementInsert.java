package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		java.util.Date dob = new java.util.Date("10/10/1994");
		java.sql.Date sqlDate = new java.sql.Date(dob.getDate());
		
		java.util.Date doj = new java.util.Date("15/11/2008");
		java.sql.Date sqlDoj = new java.sql.Date(doj.getDate());
		try {
			// 1.LOAD the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// 2.Get the DB connection via Driver
			String url = "jdbc:mysql://localhost:3306/Employee_management_info";
			con = DriverManager.getConnection(url, "root", "root");

			// 3.Issue the Sql queries via Connection
			String query = " insert into employee_primary_info values(?,?,?,?," + "?,?,?,?,?,?,?) ";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2,args[1] );
			pstmt.setLong(3, Integer.parseInt(args[2]));
			pstmt.setString(4,args[3]);
			pstmt.setDate(5, sqlDate);
			pstmt.setDate(6, sqlDate);
			pstmt.setString(7, args[4]);
			pstmt.setString(8, args[5]);
			pstmt.setDouble(9, Double.parseDouble(args[6]));
			pstmt.setInt(10, Integer.parseInt(args[7]));
			pstmt.setInt(11, Integer.parseInt(args[7]));
			
			int rs = pstmt.executeUpdate();
			// 4.Process the result returned by Sql Queries
			System.out.println("No of rows affected==>" + rs);
			
			if(rs> 0) {
				System.out.println("record successfully inserted");
			}else {
				System.err.println("record not successfully inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.Close all jdbc Objects
			try {
				if (con != null) {
					con.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
