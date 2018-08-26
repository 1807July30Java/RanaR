package com.revature.service;

import java.io.InputStream;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class AddReimbursementTicketToDbService {
	private ReimbursementDAO  reimDao = new ReimbursementDAOImpl();
	private Reimbursement ticket = new Reimbursement();

	public void addTicketToDB(int empID, double reimbursementAmount, String reimbursementDesc, InputStream fileContent){
		 ticket.setEmployeeID(empID);
		 ticket.setReimbursementAmount(reimbursementAmount);
		 ticket.setReimbursementDescription(reimbursementDesc);
		 ticket.setReimbursementTicketImg(fileContent);
		 
		 reimDao.saveReimbursementRequest(ticket);
	}
}
