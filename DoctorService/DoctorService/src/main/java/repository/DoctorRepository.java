package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import model.Doctor;

public class DoctorRepository {

	Connection con = null;

	public DoctorRepository() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/ayurwedha";
		String dbUsername = "root";
		String dbPassword = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			System.out.println("connected");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void create(Doctor d) {

		String sql = "INSERT INTO doctormanagement VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, d.getDoctor_id());
			st.setString(2, d.getDoctor_name());
			st.setInt(3, d.getSpecialization());
			st.setInt(4, d.getHospital_id());
			st.setString(5, d.getNIC());
			st.setString(6, d.getEmail());
			st.setString(7, d.getPhone());
			st.setString(8, d.getPassword());

			st.executeUpdate();
			System.out.println("one row inserted...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Doctor> viewDoctor() {

		List<Doctor> doctor = new ArrayList<>();

		String sql = "SELECT * FROM doctormanagement";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Doctor d = new Doctor();
				d.setDoctor_id(rs.getInt(1));
				d.setDoctor_name(rs.getString(2));
				d.setSpecialization(rs.getInt(3));
				d.setHospital_id(rs.getInt(4));
				d.setNIC(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setPhone(rs.getString(7));
				d.setPassword(rs.getString(8));

				doctor.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return doctor;
	}
	
	public Doctor searchDoctor(int id) {

		String sql = "SELECT * FROM doctormanagement where Doctor_id = " + id;
		Doctor d = new Doctor();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				d.setDoctor_id(rs.getInt(1));
				d.setDoctor_name(rs.getString(2));
				d.setSpecialization(rs.getInt(3));
				d.setHospital_id(rs.getInt(4));
				d.setNIC(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setPhone(rs.getString(7));
				d.setPassword(rs.getString(8));

				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return d;
	}

	public void update(Doctor d) {

		String sql = "UPDATE doctormanagement SET Doctor_name=?, Specialization=?, Hospital_id=?, NIC=?, Email=?, Phone=?, Password=? WHERE Doctor_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, d.getDoctor_name());
			st.setInt(2, d.getSpecialization());
			st.setInt(3, d.getHospital_id());
			st.setString(4, d.getNIC());
			st.setString(5, d.getEmail());
			st.setString(6, d.getPhone());
			st.setString(7, d.getPassword());
			st.setInt(8, d.getDoctor_id());
			st.executeUpdate();
			
			System.out.println("one row updated...");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void delete(int id) {
		String sql = "DELETE FROM doctormanagement WHERE doctor_ID=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			st.executeUpdate();
			
			System.out.println("one row deleted...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Appointment> viewAppointment(int id){
		
		List<Appointment> appointments = new ArrayList<>();
		String sql = "SELECT * FROM appointmentmanagement where Doctor_id = " + id;
		

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Appointment a = new Appointment();
				
				a.setAppointment_id(rs.getInt(1));
				a.setAppointment_type(rs.getInt(2));
				a.setAppointment_date(rs.getString(3));
				a.setAppointment_time(rs.getString(4));
				a.setAppointment_fees(rs.getString(5));
				a.setPatient_id(rs.getInt(6));
				a.setHospital_id(rs.getInt(7));
				a.setDoctor_id(rs.getInt(8));
				
				appointments.add(a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return appointments;
	}
	

}
