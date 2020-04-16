package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


	//public Patient getPatient(int patient_id) {
		
		//String sql = "SELECT * FROM patientmanagement WHERE Patient_id="+patient_id;
		//Patient p = new Patient();
		
		//try {
			//Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery(sql);
			
			//if (rs.next()) {
				//p.setPatient_id(rs.getInt(1));
				//p.setName(rs.getString(2));
				//p.setGender(rs.getString(3));
				//p.setBirthday(rs.getDate(4));
				//p.setNic(rs.getString(5));
				//p.setPhone(rs.getString(6));
				//p.setUsername(rs.getString(7));
				//p.setPassword(rs.getString(8));
			//}
			
		//} catch (Exception e) {
			//System.out.println(e);
		//}
		
		//return p;
	//}


	//public void create(Patient p1) {
		
		//String sql = "INSERT INTO patientmanagement VALUES (?,?,?,?,?,?,?,?) ";
		
		//try {
			//PreparedStatement st = con.prepareStatement(sql);
			
			//st.setInt(1, p1.getPatient_id());
			//st.setString(2, p1.getName());
			//st.setString(3,  p1.getGender());
			//st.setDate(4, p1.getBirthday());
			//st.setString(5, p1.getNic());
			//st.setString(6,  p1.getPhone());
			//st.setString(7, p1.getUsername());
			//st.setString(8,  p1.getPassword());
			
			//st.executeUpdate();
			
		//} catch (Exception e) {
			//System.out.println(e);
		//}
		
	//}


	//public void update(Patient p1) {
		
		//String sql = "UPDATE patientmanagement SET Name=?,Gender=?,Birthday=?,Nic=?,Phone=?,username=?,password=? WHERE Patient_id=?";
		
		//try {
			//PreparedStatement st = con.prepareStatement(sql);
			
			//st.setInt(8, p1.getPatient_id());
			//st.setString(1, p1.getName());
			//st.setString(2, p1.getGender());
			//st.setDate(3, p1.getBirthday());
			//st.setString(4, p1.getNic());
			//st.setString(5, p1.getPhone());
			//st.setString(6,  p1.getUsername());
			//st.setString(7,  p1.getPassword());
			
			//st.executeUpdate();
		
		//} catch (Exception e) {
			//System.out.println(e);
		//}
		
	//}


	//public void delete(int patient_id) {
		//String sql = "DELETE FROM patientmanagement WHERE Patient_id=?";
		
		//try {
			//PreparedStatement st = con.prepareStatement(sql);
			
			//st.setInt(1, patient_id);
			
			//st.executeUpdate();
			
		//} catch (Exception e) {
			//System.out.println(e);
		//}
		
	//}

}
