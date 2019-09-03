package com.gmx0807.domain;

//기초 데이터 세팅
public class EmpData {
	// emp
	private int empno;
	private int mgr;
	private double sal;
	private double comm;
	private int deptno;
	private String ename;
	private String job;
	private String hiredate;

	public EmpData(int empno, String ename, int mgr, String job, double sal, double comm, String hiredate, int deptno) {
		this.empno = empno;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}
	

	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public void setMgr(int mgr) {
		this.mgr = mgr;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public void setComm(double comm) {
		this.comm = comm;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}


	public String getData() {
		return empno + " " + ename + " " + mgr + " " + job + " " + sal + " " + comm + " " + hiredate + " " + deptno; 
	}
}
