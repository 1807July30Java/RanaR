package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String filename = "connection.properties";
		
		Connection con = ConnectionUtil.getConnectionFromFile(filename);
		System.out.println(con.toString());
		
		/*
		EmployeeDAO em = new EmployeeDAOImpl();
		Employee ne = new Employee();
		List<Employee> eList = new ArrayList<>();
		ne = em.getEmployeeAccountByUserName("john12");
		eList = em.getAllEmployeesUnderManager("john12");
		System.out.println(eList);
		*/
	}

}
