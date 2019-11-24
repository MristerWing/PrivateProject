package com.java.di10;

public class Admin implements IAdmin {
	private String id;
	private String pwd;

	public Admin() {
	}

	public Admin(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public void disp() {
		System.out.println(id + ", " + pwd);
	}

}
