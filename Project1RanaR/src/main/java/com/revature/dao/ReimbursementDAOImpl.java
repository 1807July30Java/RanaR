package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static String filename = "connection.properties";
	//private static Logger log = Logger.getRootLogger();
	
	@Override
	public List<Reimbursement> getAllReimbursementRequestsForEmployee(int empID) {
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		Reimbursement re = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM REIMBURSEMENT_REQUESTS WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();

			// do something with result
			while (rs.next()) {
				int reimbursementID = rs.getInt("REIMBURSEMENT_REQUEST_ID");
				int employeeID = rs.getInt("EMPLOYEE_ID");
				double reimbursementAmount = rs.getDouble("REIMBURSEMENT_AMOUNT");
				int reimbursementStatus = rs.getInt("REIMBURSEMENT_STATUS");
				String reimbursementDescription = rs.getString("REIMBURSEMENT_DESCRIPTION");
				Blob reimbursementTicketImg = rs.getBlob("REQUEST_TICKET_IMG");
				re = new Reimbursement(reimbursementID, employeeID, reimbursementAmount, reimbursementStatus, reimbursementDescription, reimbursementTicketImg);
				reimList.add(re);
			}
			
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reimList;
	}

	@Override
	public boolean saveReimbursementRequest(Reimbursement ticket) {
		if (ticket == null) {
			System.out.println("Empty reimbursement ticket");
			return false;
		}

		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO REIMBURSEMENT_REQUESTS (EMPLOYEE_ID, REIMBURSEMENT_AMOUNT, REIMBURSEMENT_DESCRIPTION, REQUEST_TICKET_IMG) VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ticket.getEmployeeID());
			pstmt.setDouble(2, ticket.getReimbursementAmount());
			pstmt.setString(3, ticket.getReimbursementDescription());
			pstmt.setBlob(4, ticket.getReimbursementTicketImg());
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			con.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Please enter valid inputs");
		return false;

	}

	@Override
	public boolean approveReimbursementRequest(int reimbursementID) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			// use a prepared statement
			String sql = "UPDATE REIMBURSEMENT_STATUS SET REIMBURSEMENT_STATUS = ? WHERE REIMBURSEMENT_REQUEST_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, reimbursementID);

			pstmt.executeUpdate();
			con.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println("Could not update approval of ticket");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean declineReimbursementRequest(int reimbursementID) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			// use a prepared statement
			String sql = "UPDATE REIMBURSEMENT_STATUS SET REIMBURSEMENT_STATUS = ? WHERE REIMBURSEMENT_REQUEST_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, -1);
			pstmt.setInt(2, reimbursementID);

			pstmt.executeUpdate();
			con.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println("Could not update database to decline ticket");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
