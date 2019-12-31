package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileReader {
	public static void main(String[] args) {

		try {
			FileInputStream inputStream = new FileInputStream(
					"dbInfo.properties"); /* we will read the file using FileInputStream */
			Properties properties = new Properties();
			properties.load(inputStream);
			System.out.println("Driver Name==>" + properties.getProperty("driveNm"));
			System.out.println("DB Url==>" + properties.getProperty("dbUrl"));
			System.out.println("User==>" + properties.getProperty("user"));
			System.out.println("Password==>" + properties.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of the Main
}// End of Class
