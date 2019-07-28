package com.revature.daos;

import java.sql.SQLException;
import java.util.List;
import com.revature.beans.Employee;
public interface EmployeeDao {
		
		void createEmployee(Employee e) throws SQLException;
		List<Employee> getEmployeeList() throws SQLException;
		Employee employeeProfile(String user, String pw) throws SQLException;
		Employee EmpByUsername(String user) throws SQLException;
	}
