package com.revature.beans;

import java.io.InputStream;

public class Reimbursement {
	private int reimbursementID;
	private int employeeID;
	private double reimbursementAmount;
	private int reimbursementStatus;
	private String reimbursementDescription;
	private InputStream reimbursementTicketImg;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbursementID, int employeeID, double reimbursementAmount, int reimbursementStatus, String reimbursementDescription,
			InputStream reimbursementTicketImg) {
		super();
		this.reimbursementID = reimbursementID;
		this.employeeID = employeeID;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementTicketImg = reimbursementTicketImg;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public int getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(int reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public InputStream getReimbursementTicketImg() {
		return reimbursementTicketImg;
	}

	public void setReimbursementTicketImg(InputStream reimbursementTicketImg) {
		this.reimbursementTicketImg = reimbursementTicketImg;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", employeeID=" + employeeID
				+ ", reimbursementAmount=" + reimbursementAmount + ", reimbursementStatus=" + reimbursementStatus
				+ ", reimbursementDescription=" + reimbursementDescription + ", reimbursementTicketImg="
				+ reimbursementTicketImg + "]";
	}
}
