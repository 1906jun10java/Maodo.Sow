package com.revature.daos;

import java.sql.SQLException;

import com.revature.beans.LoginT;

	public interface LoginTDao {
		void createLogin(LoginT l)  throws SQLException;
		void deleteLoginT(String user) throws SQLException;
		void updateLoginT(String user, String pw, int empid) throws SQLException;
		boolean LoginValidation(String username, String password)  throws SQLException;
	}
