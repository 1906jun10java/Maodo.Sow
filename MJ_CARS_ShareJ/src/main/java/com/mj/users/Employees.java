package com.mj.users;

public class Employees {
	
	private int empID;
	private String firstname;
	private String lastname;
	private String empemail;
	private String empusername;
	private String emppw;
	
	public Employees(int empID, String firstname, String lastname, String empemail, String empusername, String emppw) {
		super();
		this.empID = empID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.empemail = empemail;
		this.empusername = empusername;
		this.emppw = emppw;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
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

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public String getEmpusername() {
		return empusername;
	}

	public void setEmpusername(String empusername) {
		this.empusername = empusername;
	}

	public String getEmppw() {
		return emppw;
	}

	public void setEmppw(String emppw) {
		this.emppw = emppw;
	}

	@Override
	public String toString() {
		return "Employees [empID=" + empID + ", firstname=" + firstname + ", lastname=" + lastname + ", empemail="
				+ empemail + ", empusername=" + empusername + ", emppw=" + emppw + "]";
	}

	
	
	
}
