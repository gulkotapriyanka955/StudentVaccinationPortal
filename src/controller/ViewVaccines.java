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
import model.Vaccine;


@WebServlet("/viewVaccines")
public class ViewVaccines extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VaccineDao vaccineDao = new VaccineDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewVaccines() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			requestToViewVaccines(request, response);
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

private void requestToViewVaccines(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Vaccine> vaccines = vaccineDao.getVaccine(); 
		request.setAttribute("vaccines", vaccines);
		request.setAttribute("student_ID", request.getParameter("student_ID"));		
		request.setAttribute("emailId", request.getParameter("emailId"));
		//System.out.println("student_ID"+request.getParameter("student_ID"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewVaccines.jsp");
		dispatcher.forward(request, response);
		
	}
}
