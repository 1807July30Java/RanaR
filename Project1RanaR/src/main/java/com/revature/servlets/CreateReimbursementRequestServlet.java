package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.service.AddReimbursementTicketToDbService;

/**
 * Servlet implementation class CreateReimbursementRequestServlet
 */
@MultipartConfig
public class CreateReimbursementRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbursementRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/html/createReimbursementRequest.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		double reimbursementAmount = Double.parseDouble(request.getParameter("reimbursementAmount"));
		String reimbursementDesc = request.getParameter("reimbursementDesc");
		Part filepart = request.getPart("reimbursementReceipt");
		InputStream fileContent = filepart.getInputStream();
		int empID = (int) session.getAttribute("id");
		
		AddReimbursementTicketToDbService arttds = new AddReimbursementTicketToDbService();
		arttds.addTicketToDB(empID, reimbursementAmount, reimbursementDesc, fileContent);
		
		response.sendRedirect("crrs");
	}

}
