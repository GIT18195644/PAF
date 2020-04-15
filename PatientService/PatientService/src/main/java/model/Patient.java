package model;

import java.sql.Date;

public class Patient {
	private int Patient_id;
	private String Name;
	private String Gender;
	private Date Birthday;
	private String Nic;
	private String Phone;
	private String username;
	private String password;
	public int getPatient_id() {
		return Patient_id;
	}
	public void setPatient_id(int patient_id) {
		Patient_id = patient_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public String getNic() {
		return Nic;
	}
	public void setNic(String nic) {
		Nic = nic;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Patient [Patient_id=" + Patient_id + ", Name=" + Name + ", Gender=" + Gender + ", Birthday=" + Birthday
				+ ", Nic=" + Nic + ", Phone=" + Phone + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
