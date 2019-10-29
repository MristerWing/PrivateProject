package com.java.guest.dao;

public class GuestDao {
	private static GuestDao instance = new GuestDao();
	
	public static GuestDao getInstance() {
		return instance;
	}
	
	private GuestDao() {}
	
	
}
