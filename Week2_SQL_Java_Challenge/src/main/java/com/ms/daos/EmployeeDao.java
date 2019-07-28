package com.ms.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ms.services.Employee;

	public interface EmployeeDao {
		
		void createNewEmployee(Employee e) throws SQLException;
		List<Employee> getEmployeeList() throws SQLException;
		void AverageByDep() throws SQLException;

		
	}
