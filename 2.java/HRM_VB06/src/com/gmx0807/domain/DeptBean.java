package com.gmx0807.domain;

public class DeptBean {
	//dept
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptBean(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	//use empno Not Found 
	public DeptBean(int deptno) {
		this.deptno = deptno;
	}
	
	public String getData() {
		return deptno + " " + dname + " " + loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
