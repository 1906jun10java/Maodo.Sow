package com.ms.daos;

import java.sql.SQLException;
import java.util.List;

import com.ms.services.Department;

public interface DepartmentDao {
	
	 	List<Department> getDepartmentList() throws SQLException;
}