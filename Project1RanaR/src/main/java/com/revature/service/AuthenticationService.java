package com.revature.service;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class AuthenticationService {
	public AuthenticationService() {
	}

	public static boolean isValidUser(String username, String password) {
		Employee emp = new Employee(username, password);
		
		EmployeeDAO empCheck = new EmployeeDAOImpl();
		empCheck.isExistingEmployee(emp);
		
		return empCheck.isExistingEmployee(emp);
	}
}
