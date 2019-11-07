package com.gmx0807.consumer.dto;

import java.util.Date;

public class ConsumerDto {
	private String id;
	private String password;
	private String email;
	private String findPassword;
	private	String name;
	private Date registerDate;
	
	public ConsumerDto() {};
	
	public ConsumerDto(String id, String password, String email, String findPassword, String name, Date registerDate) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.findPassword = findPassword;
		this.name = name;
		this.registerDate = registerDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFindPassword() {
		return findPassword;
	}

	public void setFindPassword(String findPassword) {
		this.findPassword = findPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "ConsumerDto [id=" + id + ", password=" + password + ", email=" + email + ", findPassword="
				+ findPassword + ", name=" + name + ", registerDate=" + registerDate + "]";
	}
	
}
