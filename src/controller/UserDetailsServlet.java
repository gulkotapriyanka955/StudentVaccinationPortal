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

@WebServlet("/userDetails")
public class UserDetailsServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public UserDetailsServlet() {
		// TODO Auto-generated constructor stub
	}

		StudentDao studentDao = new StudentDao();
	       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
			try {
				handleRequestForUserDetails(request, response);
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
		
	private void handleRequestForUserDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
			
		Student student = studentDao.getStudent(request.getParameter("emailId"));
			request.setAttribute("student", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateAccount.jsp");
			dispatcher.forward(request, response);
		}

	}

