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
				int reimbursementStatus = rs.getInt("REIMBURSEMENT_STATUS");
				String reimbursementDescription = rs.getString("REIMBURSEMENT_DESCRIPTION");
				Blob reimbursementTicketImg = rs.getBlob("REQUEST_TICKET_IMG");
				re = new Reimbursement(reimbursementID, employeeID, reimbursementStatus, reimbursementDescription, reimbursementTicketImg);
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
	public void saveReimbursementRequest(Reimbursement ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public void approveReimbursementRequest(int reimbursementID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void declineReimbursementRequest(int reimbursementID) {
		// TODO Auto-generated method stub

	}

}
