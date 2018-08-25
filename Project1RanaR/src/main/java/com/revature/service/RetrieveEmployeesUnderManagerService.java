package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class RetrieveEmployeesUnderManagerService {
	private EmployeeDAO  eDao = new EmployeeDAOImpl();

	public List<Employee> returnAllEmployeesUnderManager(String username){
		return eDao.getAllEmployeesUnderManager(username);
	}
}
