package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3094944278526653705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/html/login.html").forward(req, resp);
	}
	
	// perform authentication for POST request
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		//PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		//grab params from request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (AuthenticationService.isValidUser(username, password)) {
			EmployeeDAO empDao = new EmployeeDAOImpl();
			Employee emp = new Employee();
			emp = empDao.getEmployeeAccountByUserName(username);
			
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("firstName", emp.getFirstName());
			session.setAttribute("lastName", emp.getLastName());
			session.setAttribute("employeeManager", emp.getEmployeeManager());
			session.setAttribute("isManager", emp.getIsManager());
			session.setAttribute("id", emp.getEmployeeID());
			session.setAttribute("email", emp.getEmployeeEmail());
			session.setAttribute("employeeToView", null);
			session.setAttribute("problem", null);
			
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
	}
}
