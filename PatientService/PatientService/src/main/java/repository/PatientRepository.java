package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
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


	public Patient getPatient(int patient_id) {
		
		String sql = "SELECT * FROM patientmanagement WHERE Patient_id="+patient_id;
		Patient p = new Patient();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				p.setPatient_id(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setGender(rs.getString(3));
				p.setBirthday(rs.getDate(4));
				p.setNic(rs.getString(5));
				p.setPhone(rs.getString(6));
				p.setUsername(rs.getString(7));
				p.setPassword(rs.getString(8));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return p;
	}


	public void create(Patient p1) {
		
		String sql = "INSERT INTO patientmanagement VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, p1.getPatient_id());
			st.setString(2, p1.getName());
			st.setString(3,  p1.getGender());
			st.setDate(4, p1.getBirthday());
			st.setString(5, p1.getNic());
			st.setString(6,  p1.getPhone());
			st.setString(7, p1.getUsername());
			st.setString(8,  p1.getPassword());
			
			st.executeUpdate();
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
	}


	public void update(Patient p1) {
		
		String sql = "UPDATE patientmanagement SET Name=?,Gender=?,Birthday=?,Nic=?,Phone=?,username=?,password=? WHERE Patient_id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(8, p1.getPatient_id());
			st.setString(1, p1.getName());
			st.setString(2, p1.getGender());
			st.setDate(3, p1.getBirthday());
			st.setString(4, p1.getNic());
			st.setString(5, p1.getPhone());
			st.setString(6,  p1.getUsername());
			st.setString(7,  p1.getPassword());
			
			st.executeUpdate();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	public void delete(int patient_id) {
		String sql = "DELETE FROM patientmanagement WHERE Patient_id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, patient_id);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	public void createAppointment(Appointment a1) {
		String sql = "INSERT INTO appointmentmanagement(appointment_id, Appointment_type, Appointment_date, Appointment_time, Appointment_fees, Patient_id, Hospital_id, Doctor_id) VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, a1.getAppointment_id());
			st.setInt(2, a1.getAppointment_type());
			st.setString(3, a1.getAppointment_date());
			st.setString(4, a1.getAppointment_time());
			st.setString(5, a1.getAppointment_fees());
			st.setInt(6, a1.getPatient_id());
			st.setInt(7, a1.getHospital_id());
			st.setInt(8, a1.getDoctor_id());

			st.executeUpdate();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}


	public void createPaymentAppointment(Appointment a1) {
		// TODO Auto-generated method stub
		
	}


	//public Appointment getAppointmentAdmin(int appointment_id) {
		
		//String sql = "SELECT * FROM appointmentmanagement where appointment_id=" + appointment_id;
		//Appointment a = new Appointment();

		//try {
			//Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery(sql);

			//if (rs.next()) {
				//a.setAppointment_id(rs.getInt(1));
				//a.setAppointment_type(rs.getInt(2));
				//a.setAppointment_date(rs.getString(3));
				//a.setAppointment_time(rs.getString(4));
				//a.setAppointment_fees(rs.getString(5));
				//a.setPatient_id(rs.getInt(6));
				//a.setHospital_id(rs.getInt(7));
				//a.setDoctor_id(rs.getInt(8));
			//}
		//} catch (Exception e) {
			//System.out.println(e);
		//}
		
		//return a;
	//}


	//public void deleteAppointment(int patient_id, int appointment_id) {
		//String sql = "DELETE FROM appointmentmanagement WHERE Patient_id=? AND appointment_id=?";

		//try {
			//PreparedStatement st = con.prepareStatement(sql);

			//st.setInt(1, appointment_id);
			//st.setInt(2, patient_id);

			//st.executeUpdate();
		//} catch (Exception e) {
			//System.out.println(e);
		//}		
	//}


	//public void updateAppointment(Appointment a1) {
		//String sql = "UPDATE appointmentmanagement SET Appointment_type=?, Appointment_date=?, Appointment_time=?, Appointment_fees=?, Patient_id=?, Hospital_id=?, Doctor_id=? WHERE appointment_id=?";

		//try {
			//PreparedStatement st = con.prepareStatement(sql);

			//st.setInt(1, a1.getAppointment_type());
			//st.setString(2, a1.getAppointment_date());
			//st.setString(3, a1.getAppointment_time());
			//st.setString(4, a1.getAppointment_fees());
			//st.setInt(5, a1.getPatient_id());
			//st.setInt(6, a1.getHospital_id());
			//st.setInt(7, a1.getDoctor_id());

			//st.setInt(8, a1.getAppointment_id());

			//st.executeUpdate();
		//} catch (Exception e) {
			//System.out.println(e);
		//}
	//}

}
