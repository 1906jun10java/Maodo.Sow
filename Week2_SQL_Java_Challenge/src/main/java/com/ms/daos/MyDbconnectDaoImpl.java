package com.ms.daos;

import java.sql.Connection;
import java.sql.SQLException;

import com.ms.services.ConnectionService;

	public class MyDbconnectDaoImpl implements mydbconnectDao {
	
		public static ConnectionService cf = ConnectionService.getInstance();
			//private Connection conn = cf.getConnection();

		public void connectdb() {
			Connection conn = cf.getConnection();
			System.out.println("Successfully connected");
		}

}
