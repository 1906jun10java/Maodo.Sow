package com.mj.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mj.users.Cars;
import com.mj.users.Customers;

import com.mj.utility.ConnectionService;

	public class customerDaoImpl implements customerDao {
		
		
		public static ConnectionService cf = ConnectionService.getInstance();
		//private Connection conn = cf.getConnection();

		@Override
		public void createcustomer(Customers c) throws SQLException {
			
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO CUSTOMERS VALUES(CUSTSEQ.NEXTVAL,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getFirstname());
			ps.setString(2, c.getLastname());
			ps.setString(3, c.getCustemail());
			ps.setString(4, c.getCustusername());
			ps.setString(5, c.getCustpw());
			
			ps.executeUpdate();
		}

	}
		
