package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetReimbursementTicketsServlet
 */
public class GetReimbursementTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReimbursementTicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if((int) session.getAttribute("isManager") == 1) {
				int empIDUnderMang = (Integer.parseInt(request.getParameter("employeeID")));
				session.setAttribute("employeeToView", empIDUnderMang);
				response.sendRedirect("drts");
			}
			else {
				response.sendRedirect("login");
			}
			
		}
	}

}
