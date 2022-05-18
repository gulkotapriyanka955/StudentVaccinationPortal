package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import model.Student;


@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public StudentLoginServlet() {
		super();
	}

	StudentDao studentDao = new StudentDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			loginRequestForStudent(request, response);
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
	
private void loginRequestForStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
	String emailId = request.getParameter("emailId");
    String password = request.getParameter("password");
    String result = "";
    Student student = studentDao.checkLogin(emailId, password);
    RequestDispatcher dispatcher;
    
    if (student!= null) {
        HttpSession session = request.getSession();
        session.setAttribute("student", student);
        result = "Student Authenticated";
        dispatcher = request.getRequestDispatcher("user-home.jsp");
    } else {
    	result = "Username or Password is incorrect";
		dispatcher = request.getRequestDispatcher("studentLogin.jsp");
    }
     
    request.setAttribute("result", result);	
    dispatcher.forward(request, response);
	}
}

