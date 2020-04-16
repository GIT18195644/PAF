package model;

public class Hospital {
	private int Hospital_id;
	private String Hospital_name;
	private String Hospital_location;
	private String Register_no;
	private String Email;
	private String Phone;
	
	public int getHospital_id() {
		return Hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		Hospital_id = hospital_id;
	}
	public String getHospital_name() {
		return Hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		Hospital_name = hospital_name;
	}
	public String getHospital_location() {
		return Hospital_location;
	}
	public void setHospital_location(String hospital_location) {
		Hospital_location = hospital_location;
	}
	public String getRegister_no() {
		return Register_no;
	}
	public void setRegister_no(String register_no) {
		Register_no = register_no;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	@Override
	public String toString() {
		return "Hospital [Hospital_id=" + Hospital_id + ", Hospital_name=" + Hospital_name + ", Hospital_location="
				+ Hospital_location + ", Register_no=" + Register_no + ", Email=" + Email + ", Phone=" + Phone + "]";
	}
	
}
