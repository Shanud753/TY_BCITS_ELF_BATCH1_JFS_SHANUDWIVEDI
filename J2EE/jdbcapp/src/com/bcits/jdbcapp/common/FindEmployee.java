package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FindEmployee {

	public static void main(String[] args) {

		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			// 1.Load the Driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			//Class.forName("com.mysql.jdbc.Driver").newInstance();

			// 2.Get the "DB connection" via "Driver"
			String url = "jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			con = DriverManager.getConnection(url);

			// 3.Issue the Sql Queries via "Connection"
			String query = " select * from  employee_primary_info "
			                 +" where empid=1 ";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// 4.Process the result returned by SQL queries
			while (rs.next()) {
				int employeeID = rs.getInt("empid");
				String employeeNM = rs.getString("empname");
				long mobileNumber = rs.getLong("mobile");
				String email = rs.getString("official_mailid");
				Date dob = rs.getDate("DOB");
				Date joining_date = rs.getDate("DOJ");
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
				System.out.println("Employee Joining_date ==>" + joining_date);
				System.out.println("Employee designation ==>" + designation);
				System.out.println("Employee Blood-grp ==>" + blGrp);
				System.out.println("Employee Salary  ==>" + employeeSalary);
				System.out.println("Employee departId  ==>" + departmentID);
				System.out.println("Employee manager-ID ==>" + managerID);

			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		finally {
			// 5.close All the "jdbc Objects"
			try {
				if (con != null) {
					con.close();
				}

				if (rs != null) {
					rs.close();

				}
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}// End of main
}// End of class
