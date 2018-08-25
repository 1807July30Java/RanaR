package com.revature.beans;

import java.sql.Blob;

public class Reimbursement {
	private int reimbursementID;
	private int employeeID;
	private int reimbursementStatus;
	private String reimbursementDescription;
	Blob reimbursementTicketImg;
	
	public Reimbursement(int reimbursementID, int employeeID, int reimbursementStatus, String reimbursementDescription,
			Blob reimbursementTicketImg) {
		super();
		this.reimbursementID = reimbursementID;
		this.employeeID = employeeID;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementTicketImg = reimbursementTicketImg;
	}


}
