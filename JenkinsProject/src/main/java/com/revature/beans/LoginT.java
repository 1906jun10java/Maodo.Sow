package com.revature.beans;

public class LoginT {
	
	String username;                        //email address set as username
	String pw;
	int emp_id;
	
	public LoginT(String username, String pw, int emp_id) {
		super();
		this.username = username;
		this.pw = pw;
		this.emp_id = emp_id;
	}

	public LoginT(String username, String pw) {
		super();
		this.username = username;
		this.pw = pw;
	}

	public LoginT() {
	}
	public LoginT(String user) {
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_id;
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		LoginT other = (LoginT) obj;
		if (emp_id != other.emp_id)
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginT [username=" + username + ", pw=" + pw + ", emp_id=" + emp_id + "]";
	}
	
	

}
