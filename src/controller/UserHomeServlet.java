package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userHome")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		handleRequestForUserHome(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
private void handleRequestForUserHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	  String emailId = request.getParameter("emailId"); 
	  String student_ID =
	  request.getParameter("student_ID");
	  
	  request.setAttribute("emailId", emailId); 
	  request.setAttribute("student_ID",
	  student_ID);
	  
	  System.out.println("student_ID"+student_ID);
	 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-home.jsp");
		dispatcher.forward(request, response);
		
	}


}

