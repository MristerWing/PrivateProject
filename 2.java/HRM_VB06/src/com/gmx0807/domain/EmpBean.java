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
	
	public EmpBean(int empno, String ename, String job, int mgr, String hiredate, double sal, double comm, int deptno) {
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
		return empno + " " + ename + " " + job + " " + mgr + " " + hiredate + " " + sal + " " + comm + " " + deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}
	
	public void setComm(double comm) {
//		this.comm = getSal() * 0.15;
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
