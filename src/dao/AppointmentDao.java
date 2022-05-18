package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDb;
import model.Appointment;

public class AppointmentDao {

	public AppointmentDao() {
		super();// TODO Auto-generated constructor stub
	}

	ConnectDb connectDb = new ConnectDb();
	Connection connection;	
	
	public List<Appointment> getAppointments(int student_ID) throws SQLException { 
		List<Appointment> appointments = new ArrayList<Appointment>(); 
		connection = connectDb.getDbConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from javaproject.appointment where student_ID="+student_ID);  
		while(rs.next()) {
			Appointment appointment = new Appointment();
			appointment.setAppointment_ID(rs.getInt(1));
			appointment.setStudent_ID(rs.getInt(2));
			appointment.setVaccine_ID(rs.getInt(3));
			appointment.setVaccineName(rs.getString(4));
			appointment.setAppointmentDate(rs.getString(5));
			
			appointments.add(appointment);
		}
		connection.close();
		return appointments;
	}
	
	public Appointment getAppointmentById(int id) throws SQLException { 
		Appointment appointment = new Appointment();
		connection = connectDb.getDbConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from appointment where Appointment_ID="+id);  
		while(rs.next()) {			
			appointment.setAppointment_ID(rs.getInt(1));
			appointment.setStudent_ID(rs.getInt(2));
			appointment.setVaccine_ID(rs.getInt(3));
			appointment.setVaccineName(rs.getString(4));
			appointment.setAppointmentDate(rs.getString(5));
		}
		connection.close();
		return appointment;
	}
	

	public String createAppointment(Appointment appointment) throws SQLException { 
			
		String status = "";		
		connection = connectDb.getDbConnection();
		Statement stmt = connection.createStatement();
		System.out.println("Vaccine_ID:"+appointment.getVaccine_ID()+" VaccineName:"+appointment.getVaccineName());
		String sql = "INSERT INTO javaproject.appointment (student_ID,vaccine_ID,vaccineName,appointmentDate) VALUES("+appointment.getStudent_ID()+","+appointment.getVaccine_ID()+",\'"+appointment.getVaccineName()+"\',\'"+appointment.getAppointmentDate()+"\')";
		System.out.println(sql);
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	
	
	public String cancelAppointment(int appointment_ID) throws SQLException { 
		String status;
		connection = connectDb.getDbConnection();
		Statement stmt = connection.createStatement();
		String sql = "DELETE FROM javaproject.appointment where appointment_ID="+appointment_ID;
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}

}
