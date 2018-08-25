package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	public List<Reimbursement> getAllReimbursementRequestsForEmployee(int empID);
	public void saveReimbursementRequest(Reimbursement ticket);
	public void approveReimbursementRequest(int reimbursementID);
	public void declineReimbursementRequest(int reimbursementID);
}
