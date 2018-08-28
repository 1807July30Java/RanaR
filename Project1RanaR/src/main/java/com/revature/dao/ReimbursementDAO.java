package com.revature.dao;

import java.sql.Blob;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	public List<Reimbursement> getAllReimbursementRequestsForEmployee(int empID);
	public boolean saveReimbursementRequest(Reimbursement ticket);
	public boolean approveReimbursementRequest(int reimbursementID);
	public boolean declineReimbursementRequest(int reimbursementID);
	public List<Reimbursement> getPendingReimbursementRequests(int empID);
	public List<Reimbursement> getApprovedReimbursementRequests(int empID);
	public List<Reimbursement> getDeniedReimbursementRequests(int empID);
	byte[] retrieveImage(int reimbursementID);
	
}
