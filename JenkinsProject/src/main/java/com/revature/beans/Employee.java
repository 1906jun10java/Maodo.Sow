package com.revature.beans;

public class Employee {
	
	int emp_id;
	String emp_role;
	String firstname;
	String lastname;
	String dept;
	int manager_id;
	
	
	public Employee(int emp_id, String emp_role, String firstname, String lastname, String dept, int manager_id) {
		super();
		this.emp_id = emp_id;
		this.emp_role = emp_role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dept = dept;
		this.manager_id = manager_id;
	}

	public Employee(String emp_role, String firstname, String lastname, String dept, int manager_id) {
		super();
		this.emp_role = emp_role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dept = dept;
		this.manager_id = manager_id;
	}



	public Employee() {
	}

	public Employee(String emp_role, String firstname, String lastname, String dept) {
		
	}

	public Employee(String empID, String dept2, String firstName2, String lastName2, String firstName3, String dept3,
			String managerID) {
		// TODO Auto-generated constructor stub
	}

	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmp_role() {
		return emp_role;
	}
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
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


	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + emp_id;
		result = prime * result + ((emp_role == null) ? 0 : emp_role.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + manager_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (emp_role == null) {
			if (other.emp_role != null)
				return false;
		} else if (!emp_role.equals(other.emp_role))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (manager_id != other.manager_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_role=" + emp_role + ", firstname=" + firstname + ", lastname="
				+ lastname + ", dept=" + dept + ", manager_id=" + manager_id + "]";
	}
	
	
	

}

