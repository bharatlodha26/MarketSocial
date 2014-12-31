package com.mconnect.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDbHelper extends DatabaseHelper{

	static final String TABLE_NAME = "credentials";
	
	// Call the parent class constructor
	public UserDbHelper() throws ClassNotFoundException, SQLException
	{
		super();
	}

	// Create a user and saves its credentials for further use
	public void insertUser(String user, String password) throws SQLException
	{
		String sql;
		final String usernameColumn = "Username";
		final String passwordColumn = "Password";
		final String verificationStatusColumn = "verified";
		int isVerified = 0; // 0 => Account not verified
		sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES('%s','%s', %s);",
				TABLE_NAME, usernameColumn, passwordColumn,verificationStatusColumn,
				user, password, isVerified);
		System.out.println("Query to execute : " + sql);
		stmt.executeUpdate(sql);
	}

	// Finds out if the user we are trying to insert already exist in the system.
	public boolean doesUserExist(String user2) throws SQLException {
		String sql;
		sql = String.format("SELECT * FROM %s WHERE Username='%s'",TABLE_NAME, user2);
		System.out.println("Query to execute : " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("Output from user exist check : "+ rs.last());
		return rs.last();
	}
	
	public int getUserId(String user) throws SQLException
	{
		String sql;
		sql = String.format("SELECT * FROM %s WHERE Username='%s'",TABLE_NAME, user);
		System.out.println("Query to execute : " + sql);
		ResultSet rs = stmt.executeQuery(sql);

		return rs.getInt(3);
	}
}
