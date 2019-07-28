package com.ms.services;

public class Department {
	
	int dep_id;
	String dep_name;
	
	
	
	public Department(int dep_id, String dep_name) {
		super();
		this.dep_id = dep_id;
		this.dep_name = dep_name;
	}



	public Department() {
	}



	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}



	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dep_name=" + dep_name + "]";
	}



	
	

}
