package com.ms.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ms.services.ConnFactory;
import com.ms.services.Employee;

	public class EmployeeDaoImpl implements EmployeeDao{
		private static Logger log = Logger.getRootLogger();
	
		public static ConnFactory cf = ConnFactory.getInstance();
		private static Connection conn = cf.getConnection(); 

		@Override
		public void createNewEmployee(Employee e) throws SQLException {
			
			String sql = "{CALL insertEMP(?,?,?,?,?)";
			CallableStatement ps = conn.prepareCall(sql);
	
			ps.setString(1, e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setInt(3, e.getDep_id());
			ps.setDouble(4, e.getSalary());
			ps.setString(5, e.getEmail());
			
			log.info(ps.executeUpdate());
			
			
		}
	
		@Override
		public ArrayList<Employee> getEmployeeList() throws SQLException {

			ArrayList<Employee> empList = new ArrayList<Employee>();
			String sql = "SELECT * FROM EMPLOYEE";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);

			Employee e = new Employee();
			
			while (rs.next()) {
				e.setEmp_id(rs.getInt(1));
				e.setFirstname(rs.getString("FIRSTNAME"));
				e.setLastname(rs.getNString("LASTNAME"));
				e.setDep_id(rs.getInt("DEP_ID"));
				e.setSalary(rs.getDouble("SALARY"));
				e.setEmail(rs.getString("EMP_EMAIL"));
				empList.add(e);
				System.out.println(empList); 
			    System.out.println(" ");
			}
		 		return empList;
		}
		
		
		@Override
		public void AverageByDep() throws SQLException{
			
			Connection conn = cf.getConnection();
			String sql = "SELECT AVG(SALARY)FROM EMPLOYEE GROUP BY DEP_ID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while(rs.next()) {
				
				if(i == 1) {
					System.out.println("Average salary for Human Resources: "+rs.getDouble(1));
					log.info(sql);
					i++;
				}
				else if(i == 2) {
					System.out.println("Average salary for Marketing: "+rs.getDouble(1));
					log.info(sql);
					i++;
				}
				else if(i == 3) {
					System.out.println("Average salary for Sales: "+rs.getDouble(1));	
					log.info(sql);
					i++;
				}
				
				else if(i == 4) {
					System.out.println("Average salary for Sales: "+rs.getDouble(1));
					log.info(sql);
					i++;
				}
			}
		}
}
