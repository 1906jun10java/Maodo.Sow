package com.mj.users;

public class Customers {

	
	private  int customerID;
	private  String firstname, lastname, custemail, custusername, custpw;
	public Customers(int customerID, String firstname, String lastname, String custemail, String custusername,
			String custpw) {
		super();
		this.customerID = customerID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.custemail = custemail;
		this.custusername = custusername;
		this.custpw = custpw;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public String getCustusername() {
		return custusername;
	}
	public void setCustusername(String custusername) {
		this.custusername = custusername;
	}
	public String getCustpw() {
		return custpw;
	}
	public void setCustpw(String custpw) {
		this.custpw = custpw;
	}
	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", custemail=" + custemail + ", custusername=" + custusername + ", custpw=" + custpw + "]";
	}
	
	
}
