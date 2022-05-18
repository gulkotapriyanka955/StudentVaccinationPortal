package model;

public class Student {
	
	private int student_ID;
	private String emailId;
	private String password;
	private String ucmo_ID;
	private String firstName;
	private String lastName;
	private String department;
	private String contactNumber;


	public Student() {
	}
		
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getStudent_ID() {
		return student_ID;
	}

	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}

	public String getUcmo_ID() {
		return ucmo_ID;
	}

	public void setUcmo_ID(String ucmo_ID) {
		this.ucmo_ID = ucmo_ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}