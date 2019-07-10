package com.mj.users;

public class CustomerPayment {
	
	

	private int paymentID;
	private double paymentAmount;
	private int carVIN;
	
	
	
	public CustomerPayment(int paymentID, double paymentAmount, int carVIN) {
		super();
		this.paymentID = paymentID;
		this.paymentAmount = paymentAmount;
		this.carVIN = carVIN;
	}



	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}



	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public int getCarVIN() {
		return carVIN;
	}

	public void setCarVIN(int carVIN) {
		this.carVIN = carVIN;
	}



	@Override
	public String toString() {
		return "CustomerPayment [paymentID=" + paymentID + ", paymentAmount=" + paymentAmount + ", carVIN=" + carVIN
				+ "]";
	}
	
	
	
	

}
