package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentDao;
import model.Appointment;



@WebServlet("/cancelAppointment")
public class CancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentDao appointmentDao = new AppointmentDao();
       
        public CancelAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			requestForCancelAppointment(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
private void requestForCancelAppointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String result;
		String appointment_ID = request.getParameter("appointment_ID");
		Appointment cancelAppointment = appointmentDao.getAppointmentById(Integer.parseInt(appointment_ID));
		
		String vaccineName = request.getParameter("vaccineName");
		String student_ID = request.getParameter("student_ID");
		String emailId = request.getParameter("emailId");
		String status = appointmentDao.cancelAppointment(Integer.parseInt(appointment_ID));
		
		if(status == "success") {
			
			result = "Appointment for the vaccine: "+cancelAppointment.getVaccineName()+" on this date "+cancelAppointment.getAppointmentDate()+" has been cancelled";
		}
		else {
			result = "Cancellation for the vaccine: "+cancelAppointment.getVaccineName()+" on this date "+cancelAppointment.getAppointmentDate()+" is unsuccessful";
			}
		List<Appointment> appointments = appointmentDao.getAppointments(Integer.parseInt(student_ID));
		request.setAttribute("appointments", appointments);
		request.setAttribute("student_ID", student_ID);
		request.setAttribute("emailId", emailId);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewAppointment.jsp");
		dispatcher.forward(request, response);		
		
		
	}

}
