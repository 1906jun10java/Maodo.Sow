package com.revature.services;

	import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.daos.EmployeeDaoImpl;

	public class EmployeeService {
		private static EmployeeService instance;
		
		private static Employee currentEmployee;
		
		private EmployeeService() {}
		// Return singleton instance
		public static synchronized EmployeeService getInstance() {
			if (instance == null) {
				instance = new EmployeeService();
			}
			return instance;             //returning the employee instance
		}
		// Setting up the current employee
		public void setCurrentEmployee(Employee e) {
			currentEmployee = e;
		}
		// Getting the current employee
		public Employee getCurrentEmployee() {
			return currentEmployee;
		}

		//calling my employee services now
		
		// Save employee to employees

		public void createEmployee(Employee e) {
			
			EmployeeDaoImpl ed = new EmployeeDaoImpl();

			try {
				ed.createEmployee(e);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		public ArrayList<Employee> getEmployeeList() {   //getting the list of all employee
			
			EmployeeDaoImpl ed = new EmployeeDaoImpl();
			
			try {
				return ed.getEmployeeList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		
		public Employee employeeProfile(String user, String pw) {
			
			EmployeeDaoImpl ed = new EmployeeDaoImpl();
			
			try {
				return ed.employeeProfile(user, pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		public Employee EmpByUsername(String user) {
			
			EmployeeDaoImpl ed = new EmployeeDaoImpl();
			Employee emp = new Employee();
			try {
				return ed.EmpByUsername(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emp;
		}
}
