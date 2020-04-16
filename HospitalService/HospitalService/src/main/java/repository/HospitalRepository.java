package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Hospital;

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

}