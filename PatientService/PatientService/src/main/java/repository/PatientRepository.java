package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Patient;

public class PatientRepository {
	
	Connection con = null;
	
	public PatientRepository() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/ayurwedha" ;
		String dbUsername = "root" ;
		String dbPassword = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public List<Patient> getPatients() {
		
		List<Patient> patients = new ArrayList<>();
		
		String sql = "SELECT * FROM patientmanagement";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Patient p = new Patient();
				
				p.setPatient_id(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setGender(rs.getString(3));
				p.setBirthday(rs.getDate(4));
				p.setNic(rs.getString(5));
				p.setPhone(rs.getString(6));
				p.setUsername(rs.getString(7));
				p.setPassword(rs.getString(8));
				
				patients.add(p);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return patients;
	}

}
