package com.durgasoft.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static void cleanUp() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
