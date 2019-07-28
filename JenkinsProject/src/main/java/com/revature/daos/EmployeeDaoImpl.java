package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.beans.Employee;
import com.revature.utility.ConnFactory;

	public class EmployeeDaoImpl implements EmployeeDao {
		
		//private static Logger log = Logger.getRootLogger();
	
		public static ConnFactory cf = ConnFactory.getInstance();

		@Override
		public void createEmployee(Employee emp) throws SQLException {
			
			Connection conn = cf.getConnection();
			String sql = "{CALL insertEMP(?,?,?,?,?)";
			CallableStatement ps = conn.prepareCall(sql);
			Employee e = new Employee();

			ps.setString(1, e.getEmp_role());
			ps.setString(2, e.getFirstname());
			ps.setString(3, e.getLastname());
			ps.setString(4, e.getDept());
			ps.setInt(5, e.getManager_id());
			ps.executeUpdate();
			
			//log.info(ps.executeUpdate());
		}
	
		@Override
		public ArrayList<Employee> getEmployeeList() throws SQLException {

			Connection conn = cf.getConnection();
			ArrayList<Employee> empList = new ArrayList<Employee>();
			String sql = "SELECT * FROM EMPLOYEE ORDER BY DEPARTMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			Employee e = null;
			while (rs.next()) {
				e = new Employee(rs.getInt(1), rs.getString("EMP_ROLE"), rs.getString("FIRSTNAME"),
				rs.getNString("LASTNAME"), rs.getString("DEPartment"), rs.getInt("MANAGER_ID"));
				
				empList.add(e);
			}
		 	return empList;
		}
		
		@Override
		public Employee employeeProfile(String user, String pw) throws SQLException {

			Connection conn = cf.getConnection();
			Employee e= new Employee();
			String sql = "SELECT * FROM EMPLOYEE JOIN LOGINT ON EMPLOYEE.EMP_ID = LOGINT.EMP_ID  WHERE USERNAME = '"+user+"' ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
				e = new Employee(rs.getInt(1), rs.getString("EMP_ROLE"), rs.getString("FIRSTNAME"),
				rs.getNString("LASTNAME"), rs.getString("DEPartment"), rs.getInt("MANAGER_ID"));
		
		 	return e;
		}
		
		@Override
		public Employee EmpByUsername(String user) throws SQLException { 
			Connection conn = cf.getConnection();
			Employee e= new Employee();
			String sql = "SELECT * FROM EMPLOYEE JOIN LOGINT ON EMPLOYEE.EMP_ID = LOGINT.EMP_ID  WHERE USERNAME=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery(sql);
			
				e = new Employee(rs.getInt(1), rs.getString("EMP_ROLE"), rs.getString("FIRSTNAME"),
				rs.getNString("LASTNAME"), rs.getString("DEPartment"), rs.getInt("MANAGER_ID"));
	
		 	return e;
		}
	
	}
