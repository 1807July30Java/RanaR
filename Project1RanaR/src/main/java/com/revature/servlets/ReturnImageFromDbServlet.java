package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

/**
 * Servlet implementation class ReturnImageFromDbServlet
 */
public class ReturnImageFromDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnImageFromDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer ticketId = Integer.parseInt(request.getParameter("ticketId"));
		ReimbursementDAO reim = new ReimbursementDAOImpl();
		byte[] objFromDb = reim.retrieveImage(ticketId);

		response.setContentType("image/jpg");
		response.getOutputStream().write(objFromDb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
