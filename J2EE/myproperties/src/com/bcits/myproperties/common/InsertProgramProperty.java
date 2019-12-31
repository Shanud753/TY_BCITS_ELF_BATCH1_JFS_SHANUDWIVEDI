package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertProgramProperty {
	public static void main(String[] args) {
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		
		try {
		FileInputStream fileInputStream = new FileInputStream("dbinfo.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String driverName= properties.getProperty("driveNm");
		
		
			// 1.Load the "Driver"
			/*
			 * Driver driveRef = new Driver(); DriverManager.registerDriver(driveRef);
			 */
			Class.forName(driverName).newInstance(); //helps to load the driver class dynamically at run time

			// 2.Get the "DB connection" via "Driver"

			//String dburl = "jdbc:mysql://localhost:3306/Employee_management_info?user=root&password=root";
			//String dburl = "jdbc:mysql://localhost:3306/Employee_management_info";
			con= DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("user") ,properties.getProperty("password") );

			// 3.Issue "SQL Queries" via "Connection"
			String query = "select * from   employee_primary_info";
			stmt = con.createStatement();
			rs   = stmt.executeQuery(query);

			// 4."Process the Results" returned by "SQL Queries"
			while (rs.next()) {
				int employeeID = rs.getInt(1);
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

				System.out.println("************************************************");



			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {
			// 5.close All the "jdbc Objects"
			try {
				if(con!=null) {
					con.close();
				}

				if(rs!=null) {
					rs.close();

				}
				if(stmt!=null) {
					stmt.close();  
				}

			}
			catch(Exception e)
			{e.printStackTrace();
			}
		}
	}// End of the Main
}// End of Class
