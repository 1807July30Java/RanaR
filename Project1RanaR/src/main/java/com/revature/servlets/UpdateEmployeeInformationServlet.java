package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.RetrieveEmployeesUnderManagerService;

/**
 * Servlet implementation class UpdateEmployeeInformationServlet
 */
public class UpdateEmployeeInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// check whether a Session exists
		if (session != null && session.getAttribute("username") != null) {

			request.getRequestDispatcher("views/html/updateEmployeeInformation.html").forward(request, response);

		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		RetrieveEmployeesUnderManagerService reums = new RetrieveEmployeesUnderManagerService();
		
		if (session != null && session.getAttribute("username") != null) {
			response.setContentType("text/html");
			int empId = Integer.parseInt(session.getAttribute("id").toString());
			if (request.getParameter("firstName") != null) {
				String firstName = request.getParameter("firstName").toString();
				if (reums.updateEmployeeInformation("FIRSTNAME", firstName, empId)) {
					session.setAttribute("firstName", firstName);
					response.sendRedirect("profile");
				}
			} 
			else if (request.getParameter("lastName") != null) {
				String lastName = request.getParameter("lastName").toString();
				if (reums.updateEmployeeInformation("LASTNAME", lastName, empId)) {
					session.setAttribute("lastName", lastName);
					response.sendRedirect("profile");
				}
			} 
			else if (request.getParameter("email") != null) {
				String email = request.getParameter("email").toString();
				if (reums.updateEmployeeInformation("EMPLOYEE_EMAIL", email, empId)) {
					session.setAttribute("email", email);
					response.sendRedirect("profile");
				}
			}

		}
	}

}
