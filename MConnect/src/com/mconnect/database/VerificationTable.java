package com.mconnect.database;

import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

// This clas has all the code to handle the verification table
public class VerificationTable extends DatabaseHelper {

	final static String TABLE_NAME = "VerificationData";
	final static String ID_FIELD = "ID";
	final static String CODE_FIELD = "Code";
	
	public VerificationTable() throws ClassNotFoundException, SQLException
	{
		super();
	}
	
	// Adds a verification code, saves it to database and returns it too.
	public String AddVerificationCode(int userId)
	{
		// Generate a pseudo randomn verification code
		String verificationCode = UUID.randomUUID().toString().replace('-', 'a');
		String sql = String.format("INSERT INTO %s (%s, %s) VALUES(%s,'%s');",
				TABLE_NAME, ID_FIELD, CODE_FIELD,userId,verificationCode);
		
		System.out.println("Execuing : " + sql);
		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verificationCode;
	}
}
