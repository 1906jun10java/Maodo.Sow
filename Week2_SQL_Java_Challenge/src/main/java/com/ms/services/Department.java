package com.ms.services;

public class Department {
	
	int depID;
	String dep_name;
	public Department(int depID, String dep_name) {
		super();
		this.depID = depID;
		this.dep_name = dep_name;
	}
	public int getDepID() {
		return depID;
	}
	public void setDepID(int depID) {
		this.depID = depID;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	@Override
	public String toString() {
		return "Department [depID=" + depID + ", dep_name=" + dep_name + "]";
	}
	
	

}
