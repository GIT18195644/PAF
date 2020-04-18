package model;

public class CardDetails {
	private int Card_id;
	private String Username;
	private int Patient_id;
	private String Bank;
	private String Card_number;
	private String CVV;
	private String Exp_year;
	private String Exp_month;
	
	public int getCard_id() {
		return Card_id;
	}
	public void setCard_id(int card_id) {
		Card_id = card_id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	public int getPatient_id() {
		return Patient_id;
	}
	public void setPatient_id(int patient_id) {
		Patient_id = patient_id;
	}
	public String getBank() {
		return Bank;
	}
	public void setBank(String bank) {
		Bank = bank;
	}
	public String getCard_number() {
		return Card_number;
	}
	public void setCard_number(String card_number) {
		Card_number = card_number;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getExp_year() {
		return Exp_year;
	}
	public void setExp_year(String exp_year) {
		Exp_year = exp_year;
	}
	public String getExp_month() {
		return Exp_month;
	}
	public void setExp_month(String exp_month) {
		Exp_month = exp_month;
	}
	@Override
	public String toString() {
		return "CardDetails [Card_id=" + Card_id + ", Username=" + Username + ", Patient_id=" + Patient_id + ", Bank="
				+ Bank + ", Card_number=" + Card_number + ", CVV=" + CVV + ", Exp_year=" + Exp_year + ", Exp_month="
				+ Exp_month + "]";
	}
		
	
}
