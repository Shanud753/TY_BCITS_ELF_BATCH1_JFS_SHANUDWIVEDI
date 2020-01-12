package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementUpdate {
     
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1.LOAD the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String url = "jdbc:mysql://localhost:3306/Employee_management_info";
			con = DriverManager.getConnection(url, "root", "root");

			String query = "update employee_primary_info set empname=? where empid=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,args[0] );
			pstmt.setInt(2, Integer.parseInt(args[1]));
			int rs = pstmt.executeUpdate();

			System.out.println("No of rows affected==>" + rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

