package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	private static String filename = "connection.properties";
	private static Logger log = Logger.getRootLogger();
	
	public List<Employee> getEmployees() {
		List<Employee> ul = new ArrayList<Employee>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM EMPLOYEE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int employeeManager = rs.getInt("EMPLOYEE_MANAGER");
				int managerOrNot = rs.getInt("MANAGER_YORN");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				ul.add(new Employee(id, firstName, lastName, username, password, employeeManager, managerOrNot, employeeEmail));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return ul;
	}

	public Employee getEmployeeAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveEmployeeAccount(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isExistingEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}
