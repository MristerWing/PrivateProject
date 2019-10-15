package com.gmx0807.domain;

import java.util.HashMap;
import java.util.Map;

public class UserData {
	
	//define User
	public Map<String, UserBean> defData() {
		Map<String, UserBean> users = new HashMap<String, UserBean>(); //id, userClass
		
		users.put("admin", new UserBean("King", "1q2w3e!@#", "admin", 10));
		users.put("user1", new UserBean("Allen", "0000", "user", 20));
		
		return users;
	}
}
