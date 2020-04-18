package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.CardDetails;
import model.Payment;

public class PaymentRepository {

	Connection con = null;

	// DB Connection Part
	public PaymentRepository() {
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
	public List<Payment> getPaymentsAdmin() {
		List<Payment> Payment = new ArrayList<>();

		String sql = "SELECT * FROM paymentmanagement";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Payment a = new Payment();

				a.setPayment_id(rs.getInt(1));
				a.setPatient_id(rs.getInt(2));
				a.setHospital_id(rs.getInt(3));
				a.setDoctor_id(rs.getInt(4));
				a.setAppointment_id(rs.getInt(5));
				a.setFees(rs.getInt(6));
				a.setPayment_Date(rs.getString(7));
				a.setPayment_Time(rs.getString(8));
				a.setCard_id(rs.getInt(9));

				Payment.add(a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Payment;
	}

	// --02
	public Payment getPaymentAdmin(int payment_id) {
		String sql = "SELECT * FROM paymentmanagement where payment_id=" + payment_id;
		Payment a = new Payment();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				a.setPayment_id(rs.getInt(1));
				a.setPatient_id(rs.getInt(2));
				a.setHospital_id(rs.getInt(3));
				a.setDoctor_id(rs.getInt(4));
				a.setAppointment_id(rs.getInt(5));
				a.setFees(rs.getInt(6));
				a.setPayment_Date(rs.getString(7));
				a.setPayment_Time(rs.getString(8));
				a.setCard_id(rs.getInt(9));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}

	// --03
	public void deletePaymentAdministrator(int payment_id) {
		String sql = "DELETE FROM paymentmanagement WHERE payment_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, payment_id);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// --04
	public void createPayment(Payment a1) {
		String sql = "INSERT INTO paymentmanagement(Patient_id, Hospital_id, Doctor_id, Appointment_id, Fees, Payment_Date, Payment_Time, Card_id) VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, a1.getPatient_id());
			st.setInt(2, a1.getHospital_id());
			st.setInt(3, a1.getDoctor_id());
			st.setInt(4, a1.getAppointment_id());
			st.setInt(5, a1.getFees());
			st.setString(6, a1.getPayment_Date());
			st.setString(7, a1.getPayment_Time());
			st.setInt(8, a1.getCard_id());

			st.executeUpdate();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	// --05
	public void createCard(CardDetails a1) {
		String sql = "INSERT INTO creditcards(Username, Patient_id, Bank, Card_number, CVV, Exp_year, Exp_month) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, a1.getUsername());
			st.setInt(2, a1.getPatient_id());
			st.setString(3, a1.getBank());
			st.setString(4, a1.getCard_number());
			st.setString(5, a1.getCVV());
			st.setString(6, a1.getExp_year());
			st.setString(7, a1.getExp_month());

			st.executeUpdate();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	// --06
	public void updateCardDetails(CardDetails a1) {
		String sql = "UPDATE creditcards SET Username=?, Bank=?, Card_number=?, CVV=?, Exp_year=?, Exp_month=? WHERE Card_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, a1.getUsername());
			st.setString(2, a1.getBank());
			st.setString(3, a1.getCard_number());
			st.setString(4, a1.getCVV());
			st.setString(5, a1.getExp_year());
			st.setString(6, a1.getExp_month());

			st.setInt(7, a1.getCard_id());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// --07
	public CardDetails getCardDetailsAdmin(int Card_id) {
		String sql = "SELECT * FROM creditcards where Card_id=" + Card_id;
		CardDetails a = new CardDetails();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				a.setCard_id(rs.getInt(1));
				a.setUsername(rs.getString(2));
				a.setPatient_id(rs.getInt(3));
				a.setBank(rs.getString(4));
				a.setCard_number(rs.getString(5));
				a.setCVV(rs.getString(6));
				a.setExp_year(rs.getString(7));
				a.setExp_month(rs.getString(8));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}
	
	//--08
	public void deleteCard(int patient_id, int card_id) {
		String sql = "DELETE FROM creditcards WHERE patient_id=? AND card_id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, patient_id);
			st.setInt(2, card_id);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
