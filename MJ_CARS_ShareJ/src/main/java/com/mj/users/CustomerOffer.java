package com.mj.users;

public class CustomerOffer {
	
	
	private int customerID;
	private int carVIN;
	private int offerID;
	private double offerAmount;
	
	
	public CustomerOffer() {
		super();
		this.customerID = customerID;
		this.carVIN = carVIN;
		this.offerID = offerID;
		this.offerAmount = offerAmount;
	}
	public int getCustomers() {
		return customerID;
	}
	public void setCustomers(int customerID) {
		this.customerID = customerID;
	}
	public int getCars() {
		return carVIN;
	}
	public void setCars(int cars) {
		this.carVIN = cars;
	}
	public int getOfferID() {
		return offerID;
	}
	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}
	public double getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}
	
	
	@Override
	public String toString() {
		return "CustomerOffer [customers=" + customerID + ", cars=" + carVIN + ", offerID=" + offerID + ", offerAmount="
				+ offerAmount + "]";
	}
	
	
	

}
