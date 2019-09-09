package com.gmx0807.domain;

import java.util.ArrayList;

//기초 데이터 세팅
public class EmpData {
	
	//define data
	public ArrayList<EmpBean> defData() {
		ArrayList<EmpBean> emp = new ArrayList<EmpBean>();
		emp.add(new EmpBean(9999, "Smith", 1111, "IT", 3000.0, "2015-02-02", 10));
		emp.add(new EmpBean(1111, "KING", 1111, "President", 5000.0, "1996-12-02", 10));
		emp.add(new EmpBean(2323, "Allen", 9999, "Salesman", 1600.0, "2075-03-22", 20));
		
		return emp;
	}
	
	//특정 사원정보 조회 후 값 세팅하기
	public EmpBean getEmp(ArrayList<EmpBean> emp, String empno) {
		
		for(int i = 0;i < emp.size();i++) {
			String[] index = emp.get(i).getData().split(" ");
			
			for(int j = 0;j < index.length;j++) {
				if(empno.equals(index[0])) {
					return emp.get(i);
				}
			}
			
		}
		
		return new EmpBean(-1);
		
		
	}
	
	
}
