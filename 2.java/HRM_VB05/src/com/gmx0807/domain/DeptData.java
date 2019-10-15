package com.gmx0807.domain;

import java.util.ArrayList;

public class DeptData {

	//define data
	public ArrayList<DeptBean> defData() {
		ArrayList<DeptBean> dept = new ArrayList<DeptBean>();
		
		dept.add(new DeptBean(10, "ACCOUNTING", "NEW YORK"));
		dept.add(new DeptBean(20, "RESEARCH", "DALLAS"));
		dept.add(new DeptBean(30, "SALES", "CHICAGO"));
		dept.add(new DeptBean(40, "OPERATIONS", "BOSTON"));
		
		return dept;
	}
	
	//find unique deptno
		public DeptBean getDept(ArrayList<DeptBean> dept, String deptno) {
			
			for(int i = 0;i < dept.size();i++) {
				String[] index = dept.get(i).getData().split(" ");
				
				for(int j = 0;j < index.length;j++) {
					if(deptno.equals(index[0])) {
						return dept.get(i);
					}
				}
				
			}
			
			return new DeptBean(-1);
			
			
		}
}
