package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userName = "root";
		String passWord = "root123$";
		
		try {
			System.out.println("Connection to MySQL database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, passWord);
			System.out.println("Connection Successful!");
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
