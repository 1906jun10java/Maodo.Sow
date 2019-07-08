package com.ms.services;

public class Employee {
	
	int employeeID;
	String firstname;
	String lastname;
	int depID;
	int salary;
	String emp_email;
	
	public Employee() {
		super();
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.depID = depID;
		this.salary = salary;
		this.emp_email = emp_email;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public int getDepID() {
		return depID;
	}

	public void setDepID(int depID) {
		this.depID = depID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", depID="
				+ depID + ", salary=" + salary + ", emp_email=" + emp_email + "]";
	}
	
	
	

}
