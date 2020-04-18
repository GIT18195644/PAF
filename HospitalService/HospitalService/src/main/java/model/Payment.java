package model;

public class Payment {
	private int payment_id;
	private int Patient_id;
	private int Hospital_id;
	private int Doctor_id;
	private int Appointment_id;
	private int Fees;
	private String Payment_Date;
	private String Payment_Time;
	private int Card_id;
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getPatient_id() {
		return Patient_id;
	}
	public void setPatient_id(int patient_id) {
		Patient_id = patient_id;
	}
	public int getHospital_id() {
		return Hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		Hospital_id = hospital_id;
	}
	public int getDoctor_id() {
		return Doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		Doctor_id = doctor_id;
	}
	public int getAppointment_id() {
		return Appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		Appointment_id = appointment_id;
	}
	public int getFees() {
		return Fees;
	}
	public void setFees(int fees) {
		Fees = fees;
	}
	public String getPayment_Date() {
		return Payment_Date;
	}
	public void setPayment_Date(String payment_Date) {
		Payment_Date = payment_Date;
	}
	public String getPayment_Time() {
		return Payment_Time;
	}
	public void setPayment_Time(String payment_Time) {
		Payment_Time = payment_Time;
	}
	public int getCard_id() {
		return Card_id;
	}
	public void setCard_id(int card_id) {
		Card_id = card_id;
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", Patient_id=" + Patient_id + ", Hospital_id=" + Hospital_id
				+ ", Doctor_id=" + Doctor_id + ", Appointment_id=" + Appointment_id + ", Fees=" + Fees
				+ ", Payment_Date=" + Payment_Date + ", Payment_Time=" + Payment_Time + ", Card_id=" + Card_id + "]";
	}
	
	
}
