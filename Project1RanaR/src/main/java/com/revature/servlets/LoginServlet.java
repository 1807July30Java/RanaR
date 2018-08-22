package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3094944278526653705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// forward the request to our HelloWorld.html page from "hello"
		RequestDispatcher rd = req.getRequestDispatcher("views/html/login.html");
		rd.forward(req, resp);
	}
}
