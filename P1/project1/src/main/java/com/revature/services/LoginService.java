package com.revature.services;

import java.sql.SQLException;

import com.revature.beans.LoginT;
import com.revature.daos.LoginTDaoImpl;

public class LoginService {
	private static LoginService instance;
	private static LoginT currentLoginT;
	
	private LoginService() {
	}

// Return singleton instance
	public static synchronized LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance; // returning the employee instance
	}

// Setting up the current LoginT
	public void setCurrentEmployee(LoginT lg) {
		currentLoginT = lg;
	}

// Getting the current LoginT
	public LoginT getCurrentLoginT() {
		return currentLoginT;
	}
	
	public void createLogin(LoginT l) {
		LoginTDaoImpl ld = new LoginTDaoImpl();
		
		try {
			ld.createLogin(currentLoginT);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteLoginT(String user) {
		LoginTDaoImpl ld = new LoginTDaoImpl();
		try {
			ld.deleteLoginT(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateLoginT(String user, String pw, int id) {
		LoginTDaoImpl ld = new LoginTDaoImpl();
		try {
			ld.updateLoginT(user, pw, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean LoginValidation(String user, String pw) {
		
		LoginTDaoImpl ld = new LoginTDaoImpl();
		boolean l = false;
		try {
			l = ld.LoginValidation(user, pw);
			if(l=true) {
				System.out.println("Login succeded");
			}
			System.out.println("Login failed");
			return l;
		} catch 
			(SQLException e) {
			e.printStackTrace();
			return l;
		}
		
	}
}
