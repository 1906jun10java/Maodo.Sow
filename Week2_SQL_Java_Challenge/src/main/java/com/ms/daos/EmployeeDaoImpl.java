package com.ms.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ms.services.ConnectionService;
import com.ms.services.Employee;

	public class EmployeeDaoImpl implements EmployeeDao{
	
		public static ConnectionService cf = ConnectionService.getInstance();
	
		@Override
		public void insertEmployee() throws SQLException {
		
		Employee c = new Employee();
		
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(EMPIDSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getFirstname());
		ps.setString(2, c.getLastname());
		ps.setInt(3, c.getDepID());
		ps.setInt(4, c.getSalary());
		ps.setString(3, c.getEmp_email());
		ps.executeUpdate();
	}


}
