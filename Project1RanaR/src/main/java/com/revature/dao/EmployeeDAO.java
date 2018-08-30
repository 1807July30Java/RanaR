package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployeeAccountById(int id);
	public boolean isExistingEmployee(Employee e);
	public Employee getEmployeeAccountByUserName(String empUsername);
	public List<Employee> getAllEmployeesUnderManager(String managerUserName);
	public List<Employee> getAllEmployeesAndTheirManagers();
}
