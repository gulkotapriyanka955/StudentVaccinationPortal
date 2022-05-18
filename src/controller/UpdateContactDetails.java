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

@WebServlet("/updateContact")
public class UpdateContactDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UpdateContactDetails() {
		super();
	}
	StudentDao studentDao = new StudentDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			updateContactDetails(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void updateContactDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Student student = new Student();
		student.setUcmo_ID(request.getParameter("ucmo_ID"));		
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setDepartment(request.getParameter("department"));
		student.setContactNumber(request.getParameter("contactNumber"));
		student.setEmailId(request.getParameter("emailId"));
		
		RequestDispatcher dispatcher;
		String status = studentDao.updateStudentDetails(student);
		if(status == "success") {
			dispatcher = request.getRequestDispatcher("updateContactSuccess.jsp");			
		}
		else {
			dispatcher = request.getRequestDispatcher("updateContactFailed.jsp");
		}
		request.setAttribute("student", student);
		
		  request.setAttribute("emailId", request.getParameter("emailId"));
		  request.setAttribute("student_ID", request.getParameter("student_ID"));
		 
		dispatcher.forward(request, response);

}
}
