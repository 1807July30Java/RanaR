package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		// check whether a Session exists
		if (session != null && session.getAttribute("username") != null && session.getAttribute("isManager") != null) {
			if((Integer)session.getAttribute("isManager") == 0){
					request.getRequestDispatcher("views/html/profile.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("views/html/managerProfile.html").forward(request, response);
			}
		} else {
			response.sendRedirect("login");
		}
	}


}
