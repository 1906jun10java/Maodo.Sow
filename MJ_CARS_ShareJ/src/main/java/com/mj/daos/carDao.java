package com.mj.daos;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mj.users.Cars;

	public interface carDao {
	
	      public abstract void createCar(Cars c) throws SQLException ;

		public ArrayList<Cars> getAllCars() throws SQLException;
		public List<Cars> getCarByVIN(Integer VIN) throws SQLException;
	/*
	 * public void deleteCar(Cars c) throws SQLException;
	 * 
	 * 
	 * 
	 * public Cars getUserByUsername(String name) throws SQLException;
	 * 
	 * 
	 * 
	 * public int insertCar(Cars car) throws SQLException;
	 */
		

}


