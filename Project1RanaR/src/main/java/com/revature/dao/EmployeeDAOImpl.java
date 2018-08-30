package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	@Override
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

	@Override
	public Employee getEmployeeAccountById(int id) {
		Employee e = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			// do something with result
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int employeeManager = rs.getInt("EMPLOYEE_MANAGER");
				int managerOrNot = rs.getInt("MANAGER_YORN");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				e = new Employee(employeeId, firstName, lastName, username, password, employeeManager, managerOrNot, employeeEmail);
				log.info("retrieved user with id "+id);
			} else {
				log.warn("no matching user found");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return e;
	}
	
	@Override
	public Employee getEmployeeAccountByUserName(String empUsername) {
		Employee e = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empUsername);
			ResultSet rs = pstmt.executeQuery();

			// do something with result
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int employeeManager = rs.getInt("EMPLOYEE_MANAGER");
				int managerOrNot = rs.getInt("MANAGER_YORN");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				e = new Employee(employeeId, firstName, lastName, username, password, employeeManager, managerOrNot, employeeEmail);
				log.info("retrieved user with id "+ empUsername);
			} else {
				log.warn("no matching user found");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return e;
	}

	@Override
	public boolean isExistingEmployee(Employee e) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, e.getUsername().trim());
			pstmt.setString(2, e.getPassword().trim());
			
			ResultSet rs = pstmt.executeQuery();

			// do something with result
			if (rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				e.setEmployeeID(id);
				e.setIsManager(rs.getInt("MANAGER_YORN"));
				log.info("Retrieved user with id "+ id);
				
				return true;
			} else {
				log.warn("No matching user found");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employee> getAllEmployeesUnderManager(String managerUserName) {
		List<Employee> eList = new ArrayList<Employee>();
		Employee e = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_MANAGER = (SELECT EMPLOYEE_ID FROM EMPLOYEE WHERE USERNAME = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, managerUserName);
			ResultSet rs = pstmt.executeQuery();

			// do something with result
			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int employeeManager = rs.getInt("EMPLOYEE_MANAGER");
				int managerOrNot = rs.getInt("MANAGER_YORN");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				e = new Employee(employeeId, firstName, lastName, username, password, employeeManager, managerOrNot, employeeEmail);
				eList.add(e);
			} 
			
			con.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return eList;
	}

	@Override
	public List<Employee> getAllEmployeesAndTheirManagers() {
		List<Employee> ul = new ArrayList<Employee>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_MANAGER FROM EMPLOYEE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String employeeManager = rs.getString("EMPLOYEE_MANAGER");
				if(employeeManager!=null) {
					int empMang = Integer.parseInt(employeeManager);
					ul.add(new Employee(id, firstName, lastName, empMang));
				}
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return ul;
	}
	
}
