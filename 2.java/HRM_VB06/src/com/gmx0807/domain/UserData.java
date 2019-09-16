package com.gmx0807.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserData {
	
	//define User
	public Map<String, UserBean> defData() {
		Map<String, UserBean> users = new HashMap<String, UserBean>(); //id, userClass
		ArrayList<EmpBean> emp = new EmpData().defData();
		
		for(EmpBean index : emp) {
			users.put(Integer.toString(index.getEmpno()), new UserBean(index.getEname(), index.getJob(), index.getDeptno()));
		}
		
		return users;
	}
}
