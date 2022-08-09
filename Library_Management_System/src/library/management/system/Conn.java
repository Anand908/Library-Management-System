package library.management.system;

import java.sql.*;

public class Conn {
	
	private Statement s;
	private Connection c; 
	
	public Statement getStatement() {
		return s;
	}
	
	public Connection getConnection() {
		return c;
	}
	
	Conn () {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "");
			s = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
