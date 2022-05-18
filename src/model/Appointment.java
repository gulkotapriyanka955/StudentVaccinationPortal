package model;

public class Appointment {
	
	private int appointment_ID;
	private int student_ID;
	private int vaccine_ID;
	private String vaccineName;
	private String appointmentDate;
	public int getAppointment_ID() {
		return appointment_ID;
	}
	public void setAppointment_ID(int appointment_ID) {
		this.appointment_ID = appointment_ID;
	}
	public int getStudent_ID() {
		return student_ID;
	}
	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}
	public int getVaccine_ID() {
		return vaccine_ID;
	}
	public void setVaccine_ID(int vaccine_ID) {
		this.vaccine_ID = vaccine_ID;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}

