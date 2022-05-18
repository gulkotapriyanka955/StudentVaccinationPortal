package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.Student;

@WebServlet("/vaccinationRegistration")
public class VaccinationRegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	StudentDao studentDao = new StudentDao();
	
	public VaccinationRegistrationServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			requestForRegistration(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void requestForRegistration(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Student student = new Student(); 
		student.setEmailId(request.getParameter("emailId"));
		student.setPassword(request.getParameter("password"));
		student.setUcmo_ID(request.getParameter("ucmo_ID"));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setDepartment(request.getParameter("department"));
		student.setContactNumber(request.getParameter("contactNumber"));
					
		RequestDispatcher dispatcher;
		String result;
		String status = studentDao.studentDetails(student);
		if(status == "success") {
			result = "User Created Successfully. Please Log in";
		}
		else {
			result = "User Creation Failed. Please Sign up again!";
		}
		
		request.setAttribute("result", result);
		dispatcher = request.getRequestDispatcher("studentLogin.jsp");
		dispatcher.forward(request, response);
	}
	
}
