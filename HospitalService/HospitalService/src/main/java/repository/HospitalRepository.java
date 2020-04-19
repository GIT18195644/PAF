package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import model.Hospital;
import model.Payment;

public class HospitalRepository {
	Connection con = null;

	public HospitalRepository() {
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

	// --01
	public List<Hospital> getHospitals() {

		List<Hospital> hospitals = new ArrayList<>();

		String sql = "SELECT * FROM hospitalmanagement";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Hospital h = new Hospital();

				h.setHospital_id(rs.getInt(1));
				h.setHospital_name(rs.getString(2));
				h.setHospital_location(rs.getString(3));
				h.setRegister_no(rs.getString(4));
				h.setEmail(rs.getString(5));
				h.setPhone(rs.getString(6));

				hospitals.add(h);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return hospitals;

	}

	// --02
	public Hospital getHospital(int id) {

		String sql = "SELECT * FROM hospitalmanagement where Hospital_id=" + id;
		Hospital h = new Hospital();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				h.setHospital_id(rs.getInt(1));
				h.setHospital_name(rs.getString(2));
				h.setHospital_location(rs.getString(3));
				h.setRegister_no(rs.getString(4));
				h.setEmail(rs.getString(5));
				h.setPhone(rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return h;
	}

	// --03
	public void create(Hospital h1) {

		String sql = "INSERT INTO hospitalmanagement VALUES (?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, h1.getHospital_id());
			st.setString(2, h1.getHospital_name());
			st.setString(3, h1.getHospital_location());
			st.setString(4, h1.getRegister_no());
			st.setString(5, h1.getEmail());
			st.setString(6, h1.getPhone());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// --04
	public void update(Hospital h1) {

		String sql = "UPDATE hospitalmanagement SET Hospital_name=?, Hospital_location=?, Register_no=?, Email=?, Phone=? WHERE Hospital_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, h1.getHospital_name());
			st.setString(2, h1.getHospital_location());
			st.setString(3, h1.getRegister_no());
			st.setString(4, h1.getEmail());
			st.setString(5, h1.getPhone());
			st.setInt(6, h1.getHospital_id());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// --05
	public void delete(int hospital_id) {
		String sql = "DELETE FROM hospitalmanagement WHERE Hospital_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, hospital_id);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// --06
	public List<Appointment> getAppointments(int Hospital_id) {
		List<Appointment> Appointment = new ArrayList<>();

		String sql = "SELECT * FROM appointmentmanagement WHERE Hospital_id=" + Hospital_id;

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

				Appointment.add(a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Appointment;
	}

	// --07
	public List<Payment> getPayments(int hospital_id) {
		List<Payment> Payment = new ArrayList<>();

		String sql = "SELECT * FROM paymentmanagement WHERE Hospital_id=" + hospital_id;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Payment p = new Payment();

				p.setPayment_id(rs.getInt(1));
				p.setPatient_id(rs.getInt(2));
				p.setHospital_id(rs.getInt(3));
				p.setAppointment_id(rs.getInt(5));
				p.setFees(rs.getInt(6) * 15 / 100);
				p.setPayment_Date(rs.getString(7));
				p.setPayment_Time(rs.getString(8));

				Payment.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Payment;
	}

	// --08
	public List<Payment> getPaymentsSystem(int hospital_id) {
		List<Payment> Payment = new ArrayList<>();

		String sql = "SELECT * FROM paymentmanagement WHERE Hospital_id=" + hospital_id;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Payment p = new Payment();

				p.setPayment_id(rs.getInt(1));
				p.setPatient_id(rs.getInt(2));
				p.setHospital_id(rs.getInt(3));
				p.setAppointment_id(rs.getInt(5));
				p.setFees(rs.getInt(6) * 50 / 100);
				p.setPayment_Date(rs.getString(7));
				p.setPayment_Time(rs.getString(8));

				Payment.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Payment;
	}

}