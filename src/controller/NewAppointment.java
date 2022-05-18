package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentDao;
import model.Appointment;

@WebServlet("/newAppointment")
public class NewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentDao appointmentDao = new AppointmentDao();
       
    public NewAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			requestForNewAppointment(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
private void requestForNewAppointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
		
		
	    String student_ID = request.getParameter("student_ID");
		String vaccine_ID = request.getParameter("vaccine_ID");
		int id = Integer.parseInt(student_ID);
		Appointment appointment = new Appointment();
		appointment.setStudent_ID(Integer.parseInt(student_ID));
		appointment.setVaccine_ID(Integer.parseInt(vaccine_ID));		
		appointment.setVaccineName(request.getParameter("vaccineName"));

		String appointmentDate =  request.getParameter("appointmentDate");
				
		appointment.setAppointmentDate(appointmentDate);
		String status = appointmentDao.createAppointment(appointment);
		RequestDispatcher dispatcher;
		request.setAttribute("student_ID", student_ID);
		request.setAttribute("emailId", request.getParameter("emailId"));
		if(status == "success") {
			request.setAttribute("result", "Appointment Booking Successful for the vaccine: "+ request.getParameter("vaccineName") );			
		}
		else {
			request.setAttribute("result", "Appointment Booking Failed for the vaccine "+request.getParameter("vaccineName")+", Please try Again!");			
		}
		dispatcher = request.getRequestDispatcher("user-home.jsp"); 
		dispatcher.forward(request, response);
	}
}

