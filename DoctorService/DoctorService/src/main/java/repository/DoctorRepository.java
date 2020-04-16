package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void create(Doctor d) {

		String sql = "INSERT INTO hospitalmanagement VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, d.getDoctorID());
			st.setString(2, d.getFname());
			st.setString(3, d.getLname());
			st.setString(4, d.getSpecialization());
			st.setString(5, d.getEmail());
			st.setString(6, d.getNic());
			st.setInt(7, d.getPhone());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Doctor> viewDoctor() {

		List<Doctor> doctor = new ArrayList<>();

		String sql = "SELECT * FROM hospitalmanagement";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Doctor d = new Doctor();
				d.setDoctorID(rs.getInt(1));
				d.setFname(rs.getString(2));
				d.setLname(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setSpecialization(rs.getString(5));
				d.setNic(rs.getString(6));
				d.setPhone(rs.getInt(7));

				doctor.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return doctor;
	}

	public void update(Doctor d) {

		String sql = "UPDATE hospitalmanagement SET Hospital_name=?, Hospital_location=?, Register_no=?, Email=?, Phone=? WHERE Hospital_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, d.getFname());
			st.setString(2, d.getLname());
			st.setString(3, d.getSpecialization());
			st.setString(4, d.getNic());
			st.setString(5, d.getEmail());
			st.setInt(6, d.getPhone());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void delete(int id) {
		String sql = "DELETE FROM hospitalmanagement WHERE Hospital_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
