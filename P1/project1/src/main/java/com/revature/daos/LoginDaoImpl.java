package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.LoginT;
import com.revature.utility.ConnFactory;

public class LoginDaoImpl<LoginValidation> implements LoginTDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();


	@Override
	public void createLogin(LoginT l) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{CALL insertLOGIN(?,?,?)";
		CallableStatement ps = conn.prepareCall(sql);
		LoginT lg = new LoginT();
		
		ps.setString(1, lg.getUsername());
		ps.setString(2, lg.getPw());
		ps.setInt(3, lg.getEmp_id());
		ps.executeUpdate();
		
		int x = ps.executeUpdate(sql); 
        if (x > 0)             
            System.out.println("Employee Successfully created");             
        else            
            System.out.println("ERROR OCCURED :("); 
        conn.close(); 
	}

	@Override
	public void deleteLoginT(String user) throws SQLException {
	
		Connection conn = cf.getConnection();
		String sql = "DELETE LOGINT WHERE USERNAME = '"+user+"' ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		
		int x = ps.executeUpdate(sql); 
        if (x > 0)             
            System.out.println("User Successfully deleted");             
        else            
            System.out.println("ERROR OCCURED :("); 
        conn.close(); 
		
	}

	@Override
	public void updateLoginT(String user, String pw, int id) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "UPDATE LOGINT SET USERNAME = '"+user+"', PW = '"+pw+"' WHERE EMP_ID = "+id+"";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setInt(1, id);
		ps.executeUpdate();
		
		int x = ps.executeUpdate(sql); 
        if (x > 0)             
            System.out.println("Login Credentials Successfully Updated");             
        else            
            System.out.println("ERROR OCCURED :("); 
		
	}

	//Validating the user credentials
	@Override
	public boolean LoginValidation(String user, String pw) throws SQLException {
		
		Connection conn = cf.getConnection();
		boolean logtest = false;
		String sql = "SELECT USERNAME, PW FROM LOGINT WHERE USERNAME = '"+user+"' AND PW='"+pw+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		ps.executeQuery();
		
        if (rs!=null) 
        {            
        	logtest = true;
            System.out.println("Login Succeded"); 
        }
        else {        
        	logtest = false;
        }
		return logtest;
	}
	
	
}
