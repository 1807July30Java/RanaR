package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":\""+session.getAttribute("username")+"\", ");
			response.getWriter().write("\"password\":\""+session.getAttribute("password")+"\", ");
			response.getWriter().write("\"firstName\":\""+session.getAttribute("firstName")+"\", ");
			response.getWriter().write("\"lastName\":\""+session.getAttribute("lastName")+"\", ");
			response.getWriter().write("\"employeeManager\":\""+session.getAttribute("employeeManager")+"\", ");
			response.getWriter().write("\"isManager\":\""+session.getAttribute("isManager")+"\", ");
			response.getWriter().write("\"id\":\""+session.getAttribute("id")+"\", ");
			response.getWriter().write("\"email\":\""+session.getAttribute("email")+"\"}");
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":null}");
			response.getWriter().write("{\"password\":null}");
			response.getWriter().write("{\"firstName\":null}");
			response.getWriter().write("{\"lastName\":null}");
			response.getWriter().write("{\"employeeManager\":null}");
			response.getWriter().write("{\"isManager\":null}");
			response.getWriter().write("{\"id\":null}");
			response.getWriter().write("{\"email\":null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
