package com.gmx0807.domain;

public class UserBean {
	private String name;
	private String password;
	private String type;
	private int dept;
	
	public UserBean() {
		
	}
	
	public UserBean(String name, String password, String type, int dept) {
		this.name = name;
		this.password = password;
		this.type = type;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
	
	
	
	
}
