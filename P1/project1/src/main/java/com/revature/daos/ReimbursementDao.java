package com.revature.daos;

import java.sql.SQLException;
import java.util.List;
import com.revature.beans.Reimbursement;

	public interface ReimbursementDao {
		Reimbursement createReimbursement() throws SQLException;
		List<Reimbursement> getPendingReimb(int emp_id) throws SQLException;
		List<Reimbursement> getResolvedReimb(int emp_id) throws SQLException;
		List<Reimbursement> getReimbursementById(int empid) throws SQLException;
		List<Reimbursement> getReimbByDeaprtment(int manager_id) throws SQLException;
		List<Reimbursement> getAllResolvedReimb() throws SQLException;
	}
