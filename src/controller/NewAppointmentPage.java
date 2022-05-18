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

import dao.VaccineDao;


@WebServlet("/newAppointmentPage")  // In view-restaturant.jsp
public class NewAppointmentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewAppointmentPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			requestForNewAppointmentPage(request, response);
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

	
private void requestForNewAppointmentPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		VaccineDao vaccineDao = new VaccineDao();
		List<String> availableDates = vaccineDao.getAvailableDates(Integer.parseInt(request.getParameter("vaccine_ID")));
		request.setAttribute("student_ID", request.getParameter("student_ID"));
		request.setAttribute("emailId", request.getParameter("emailId"));
		request.setAttribute("vaccine_ID", request.getParameter("vaccine_ID"));
		request.setAttribute("vaccineName", request.getParameter("vaccineName"));
		//System.out.println("student_ID:"+request.getParameter("student_ID"));
		//System.out.println("vaccineID:"+request.getParameter("vaccine_ID"));
		request.setAttribute("availableDates", availableDates);
		request.setAttribute("selectedDate", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookAppointment.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
