package com.ms.services;

public class Employee{
	
			private int emp_id;
			private String firstname;
			private String lastname;
			private int dep_id;
			private double salary;
			private String email;
			
			
			public Employee(int emp_id, String firstname, String lastname, int dep_id, double salary, String email) {
				super();
				this.emp_id = emp_id;
				this.firstname = firstname;
				this.lastname = lastname;
				this.dep_id = dep_id;
				this.salary = salary;
				this.email = email;
			}


			public Employee() {
				// TODO Auto-generated constructor stub
			}

			public int getEmp_id() {
				return emp_id;
			}
			public void setEmp_id(int emp_id) {
				this.emp_id = emp_id;
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


			public int getDep_id() {
				return dep_id;
			}

			public void setDep_id(int dep_id) {
				this.dep_id = dep_id;
			}


			public double getSalary() {
				return salary;
			}

			public void setSalary(double salary) {
				this.salary = salary;
			}


			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}


			@Override
			public String toString() {
				return "Employee [emp_id=" + emp_id + ", firstname=" + firstname + ", lastname=" + lastname
						+ ", dep_id=" + dep_id + ", salary=" + salary + ", email=" + email + "]";
			}
			
			
			
			
}