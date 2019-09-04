package com.gmx0807.domain;

public class EmpBean {
	// emp
	private int empno;
	private int mgr;
	private double sal;
	private double comm;
	private int deptno;
	private String ename;
	private String job;
	private String hiredate;

	public EmpBean(int empno, String ename, int mgr, String job, double sal, double comm, String hiredate, int deptno) {
		this.empno = empno;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}
	
	//use empno Not Found 
	public EmpBean(int empno) {
		this.empno = empno;
	}

	public String getData() {
		return empno + " " + ename + " " + mgr + " " + job + " " + sal + " " + comm + " " + hiredate + " " + deptno;
	}
}
