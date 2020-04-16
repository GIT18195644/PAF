package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class HospitalRepository {
Connection con = null;
	
	public HospitalRepository() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/ayurwedha" ;
		String dbUsername = "root" ;
		String dbPassword = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
