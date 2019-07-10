package com.mj.users;

public class Cars {

	private int carVIN;
	private String carMake;
	private String carModel;
	private int yearMake;
	private double price;
	private int mileage;
	private String car_Status;
	private String lot;
	
	
	
	
	public Cars(int carVIN, String carMake, String carModel, int yearMake, double price, int mileage, String lot, String car_Status
			) {
		super();
		this.carVIN = carVIN;
		this.carMake = carMake;
		this.carModel = carModel;
		this.yearMake = yearMake;
		this.price = price;
		this.mileage = mileage;
		this.lot = lot;
		this.car_Status = car_Status;
	}
	public int getCarVIN() {
		return carVIN;
	}
	public void setCarVIN(int carVIN) {
		this.carVIN = carVIN;
	}
	public String getCarMake() {
		return carMake;
	}
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getYearMake() {
		return yearMake;
	}
	public void setYearMake(int yearMake) {
		this.yearMake = yearMake;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getCar_Status() {
		return car_Status;
	}
	public void setCar_Status(String car_Status) {
		this.car_Status = car_Status;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	@Override
	public String toString() {
		return "Cars [carVIN=" + carVIN + ", carMake=" + carMake + ", carModel=" + carModel + ", yearMake=" + yearMake
				+ ", price=" + price + ", mileage=" + mileage + ", car_Status=" + car_Status + ", lot=" + lot + "]";
	}
	
	
}
