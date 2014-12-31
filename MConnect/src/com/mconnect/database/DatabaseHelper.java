package com.mconnect.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
	
	// TODO : Get these information from Resource file
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/UserData";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Password~1";

	Connection conn = null;
	Statement stmt = null;

	// Constructor: Register and connect with DB
	public DatabaseHelper() throws ClassNotFoundException, SQLException
	{
		//STEP: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		//STEP: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);

		stmt = conn.createStatement();
	}
}
