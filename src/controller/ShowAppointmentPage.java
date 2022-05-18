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
import dao.VaccineDao;
import model.Appointment;



@WebServlet("/appointmentPage")
public class ShowAppointmentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentDao appointmentDao = new AppointmentDao();
	VaccineDao vaccineDao = new VaccineDao();
       
    public ShowAppointmentPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			requestForShowAppointmentPage(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
private void requestForShowAppointmentPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String student_ID = request.getParameter("student_ID");
		List<Appointment> appointments = appointmentDao.getAppointments(Integer.parseInt(student_ID)); 
		
		request.setAttribute("student_ID", student_ID);
		request.setAttribute("emailId", request.getParameter("emailId"));
		request.setAttribute("appointments", appointments);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewAppointment.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
