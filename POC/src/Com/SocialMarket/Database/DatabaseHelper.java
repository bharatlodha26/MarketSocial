package Com.SocialMarket.Database;

import java.sql.*;


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
	   
	public DatabaseHelper() throws ClassNotFoundException, SQLException
	{
		//STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		//STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
	}
	
	public void insertUser(String user, String password, String id) throws SQLException
	{
		//STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      String sql;
	      sql = String.format("INSERT INTO users VALUES('%s','%s','%s');",user, password, id);
	      System.out.println("Query to execute : " + sql);
	      stmt.executeUpdate(sql);
	      }

	public boolean doesUserExist(String user2) throws SQLException {
		stmt = conn.createStatement();
	      String sql;
	      sql = String.format("SELECT * FROM users WHERE Username='%s'",user2);
	      System.out.println("Query to execute : " + sql);
	      ResultSet rs = stmt.executeQuery(sql);
	      System.out.println("Output from user exist check : "+ rs.last());
	      return rs.last();
	      
	}
	
}
