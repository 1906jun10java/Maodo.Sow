package com.mj.carservices;

import com.mj.users.Customers;

	public interface custasksInterface {
		
		public void viewAllCars();
		public void viewOwnedCars(Customers customers);
		public void createAnAccount(String userId, String password);
		public void makeAMonthlyPayment(double paymentAmount, int carId);

	}
