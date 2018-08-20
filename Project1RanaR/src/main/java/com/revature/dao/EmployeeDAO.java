package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployeeAccountById(int id);
	public boolean saveEmployeeAccount(Employee e);
	public boolean isExistingEmployee(Employee e);
}
