package repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;

public class AppointmentRepository {
	Connection con = null;

	// DB Connection Part
	public AppointmentRepository() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/ayurwedha";
		String dbUsername = "root";
		String dbPassword = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// For Administrator
	// Get all the appointment
	public List<Appointment> getAppointmentsAdmin() {

		List<Appointment> appointments = new ArrayList<>();

		String sql = "SELECT * FROM appointmentmanagement";

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

	// For Patient
	// Get all the appointment
	public List<Appointment> getAppointmentsPatient(int id) {

		List<Appointment> appointments = new ArrayList<>();

		String sql = "SELECT * FROM appointmentmanagement where Patient_id=" + id;
		
		
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

	// For Administrator
	// Search appointment using appointment ID
	public Appointment getAppointmentAdmin(int id) {

		String sql = "SELECT * FROM appointmentmanagement where appointment_id=" + id;
		Appointment a = new Appointment();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				a.setAppointment_id(rs.getInt(1));
				a.setAppointment_type(rs.getInt(2));
				a.setAppointment_date(rs.getString(3));
				a.setAppointment_time(rs.getString(4));
				a.setAppointment_fees(rs.getString(5));
				a.setPatient_id(rs.getInt(6));
				a.setHospital_id(rs.getInt(7));
				a.setDoctor_id(rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}

	// For Patient
	// Search own(patient) appointment using appointment ID
	public Appointment getAppointmentPatient(int pid, int id) {
		
		String sql = "SELECT * FROM appointmentmanagement where Patient_id="+pid+"&& appointment_id="+id;
		Appointment a = new Appointment();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				a.setAppointment_id(rs.getInt(1));
				a.setAppointment_type(rs.getInt(2));
				a.setAppointment_date(rs.getString(3));
				a.setAppointment_time(rs.getString(4));
				a.setAppointment_fees(rs.getString(5));
				a.setPatient_id(rs.getInt(6));
				a.setHospital_id(rs.getInt(7));
				a.setDoctor_id(rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}

	// For Patient
	// Create Appointment
	public void create1(Appointment a1) {

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

	// For Patient
	// Update Appointment
	public void update(Appointment a1) {

		String sql = "UPDATE appointmentmanagement SET Appointment_type=?, Appointment_date=?, Appointment_time=?, Appointment_fees=?, Patient_id=?, Hospital_id=?, Doctor_id=? WHERE appointment_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, a1.getAppointment_type());
			st.setString(2, a1.getAppointment_date());
			st.setString(3, a1.getAppointment_time());
			st.setString(4, a1.getAppointment_fees());
			st.setInt(5, a1.getPatient_id());
			st.setInt(6, a1.getHospital_id());
			st.setInt(7, a1.getDoctor_id());

			st.setInt(8, a1.getAppointment_id());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// For Administrator
	// Delete own Appointment
	public void deleteAdministrator(int appointment_id) {
		String sql = "DELETE FROM appointmentmanagement WHERE appointment_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, appointment_id);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// For Patient
	// Delete own Appointment
	public void delete(int appointment_id, int Patient_id) {
		String sql = "DELETE FROM appointmentmanagement WHERE Patient_id=? AND appointment_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, appointment_id);
			st.setInt(2, Patient_id);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
