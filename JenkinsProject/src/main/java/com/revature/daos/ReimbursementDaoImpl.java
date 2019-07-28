package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.utility.ConnFactory;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Reimbursement createReimbursement() throws SQLException {

		Connection conn = cf.getConnection();
		String sql = "{CALL insertREIMB(?,?,?,?,?,?)";
		CallableStatement ps = conn.prepareCall(sql);

		Reimbursement r = new Reimbursement();

		ps.setDouble(1, r.getR_amount());
		ps.setString(2, r.getR_type());
		ps.setString(3, r.getR_receipt());
		ps.setString(4, r.getR_status());
		ps.setDate(5, r.getR_date());
		ps.setInt(6, r.getEmp_id());
		ps.executeUpdate();

		return r;
	}

	@Override
	public List<Reimbursement> getPendingReimb(int e_id) throws SQLException {

		Connection conn = cf.getConnection();
		ArrayList<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE R_STATUS = 'Pending' AND EMP_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e_id);
		ResultSet rs = ps.executeQuery(sql);

		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getInt(7));
			reimbList.add(r);
		}
		return reimbList;
	}

	@Override
	public List<Reimbursement> getResolvedReimb(int e_id) throws SQLException {

		Connection conn = cf.getConnection();
		ArrayList<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE R_STATUS != 'Pending' AND EMP_ID =? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e_id);
		ResultSet rs = ps.executeQuery(sql);

		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getInt(7));
			reimbList.add(r);
		}
		return reimbList;

	}

	@Override
	public List<Reimbursement> getReimbursementById(int e_id) throws SQLException {
		Connection conn = cf.getConnection();
		List<Reimbursement> reimbList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE EMP_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e_id);
		ResultSet rs = ps.executeQuery();

		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getInt(7));
			reimbList.add(r);
		}
		return reimbList;
	}

	@Override
	public List<Reimbursement> getReimbByDeaprtment(int m_id) throws SQLException {

		Connection conn = cf.getConnection();
		List<Reimbursement> reimbList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE R_STATUS = 'Pending' AND EMP_ID IN (SELECT EMP_ID FROM EMPLOYEE WHERE MANAGER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, m_id);
		ResultSet rs = ps.executeQuery();

		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getInt(7));
			reimbList.add(r);
		}
		return reimbList;

	}

	@Override
	public List<Reimbursement> getAllResolvedReimb() throws SQLException {

		Connection conn = cf.getConnection();
		ArrayList<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE R_STATUS != 'Pending' ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);

		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getInt(7));
			reimbList.add(r);
		}
		return reimbList;
	}

}
