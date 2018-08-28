package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class RetrieveEmployeesUnderManagerService {
	private EmployeeDAO  eDao = new EmployeeDAOImpl();
	private ReimbursementDAO reimDao = new ReimbursementDAOImpl();

	public List<Employee> returnAllEmployeesUnderManager(String username){
		return eDao.getAllEmployeesUnderManager(username);
	}
	
	public List<Reimbursement> returnPendingRequests(int empID){
		
		return reimDao.getPendingReimbursementRequests(empID);
	}
}
