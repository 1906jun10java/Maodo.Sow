package com.mj.daos;

import com.mj.users.Employees;

public interface employeeDao {
		
		public void createNewEmployee(Employees employees);
		public int getEmpIDByUsername(String username);
		public boolean employeeLogValidation(String username, String password);
	}


