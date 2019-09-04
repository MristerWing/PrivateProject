package com.gmx0807.domain;

import java.util.ArrayList;

//기초 데이터 세팅
public class EmpData {
	public ArrayList<EmpBean> defData() {
		ArrayList<EmpBean> emp = new ArrayList<EmpBean>();
		emp.add(new EmpBean(9999, "Smith", 1111, "IT", 3000.0, 300.0, "2015-02-02", 10));
		emp.add(new EmpBean(1111, "KING", 1111, "President", 5000.0, 800.0, "1996-12-02", 10));
		emp.add(new EmpBean(2323, "Allen", 9999, "Salesman", 1600.0, 300.0, "2075-03-22", 20));
		
		return emp;
	}
	
	
}
