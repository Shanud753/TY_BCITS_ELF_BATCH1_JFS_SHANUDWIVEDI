package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Load the Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// 2.Get the DB Connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/employee_management_info";
			con = DriverManager.getConnection(dbUrl, "root", "root");

			// 3.Issue SQL Queries Via Connection
			String query = " select * from  employee_primary_info " 
			                + " where empid=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			rs = pstmt.executeQuery();

			// 4.Process the result returned by Sql Queries
			if (rs.next()) {
				int employeeID = rs.getInt("empid");
				String employeeNM = rs.getString("empname");
				long mobileNumber = rs.getLong("mobile");
				String email = rs.getString("official_mailid");
				Date dob = rs.getDate("DOB");
				Date joining_Date = rs.getDate("DOJ");
				String designation = rs.getString("designation");
				String blGrp = rs.getString("bld_grp");
				double employeeSalary = rs.getDouble("salary");
				int departmentID = rs.getInt("Dept_id");
				int managerID = rs.getInt("manager_id");

				System.out.println("Employee Id ==>" + employeeID);
				System.out.println("Employee Name  ==>" + employeeNM);
				System.out.println("Employee mobileNumber==>" + mobileNumber);
				System.out.println("Employee email-id ==>" + email);
				System.out.println("Employee Date of birth ==>" + dob);
				System.out.println("Employee Joining_date ==>" + joining_Date);
				System.out.println("Employee designation ==>" + designation);
				System.out.println("Employee Blood-grp ==>" + blGrp);
				System.out.println("Employee Salary  ==>" + employeeSalary);
				System.out.println("Employee departId  ==>" + departmentID);
				System.out.println("Employee manager-ID ==>" + managerID);
			}else {
				System.err.println("Employee Data Not Found in DB"); //"err" show messages in red colour and "ut" in black colour
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close All the "jdbc Objects"
			try {
				if (con != null) {
					con.close();
				}

				if (rs != null) {
					rs.close();

				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}// End of Main
}// End of Class
