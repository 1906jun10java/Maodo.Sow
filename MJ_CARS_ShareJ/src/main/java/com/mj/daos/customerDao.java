package com.mj.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mj.users.Cars;
import com.mj.users.Customers;

public interface customerDao {
	
	public abstract void createcustomer(Customers c) throws SQLException ;

	/*
	 * public int getCustomerByUsername(String username); public boolean
	 * customerLogValidation(String username, String password); public void
	 * updateCustomer(Customers c); public void deleteCustomer(Customers c); public
	 * List<Customers> getAllCustomers(); pu
	 */  
}


