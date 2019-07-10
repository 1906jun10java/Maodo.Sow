package com.mj.daos;

import java.util.List;

import com.mj.users.CustomerPayment;

	public interface paymentDao {
		
		public void createPayment(int carId, double paymentAmount);
		public List<CustomerPayment> getAllPayments();
		public List<CustomerPayment> getPaymentsByCarId(int carId);
	}

