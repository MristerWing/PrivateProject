package com.java.sawon;

import java.util.Date;

public class SawonDto {
	private int employee_id;
	private String first_name;
	private Date hire_date;
	private String job_id;
	private long salary;
	private int department_id;
	private	String department_name;
	
	public SawonDto() {}

	public SawonDto(int employee_id, String first_name, Date hire_date, String job_id, long salary, int department_id,
			String department_name) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.department_id = department_id;
		this.department_name = department_name;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "SawonDto [employee_id=" + employee_id + ", first_name=" + first_name + ", hire_date=" + hire_date
				+ ", job_id=" + job_id + ", salary=" + salary + ", department_id=" + department_id
				+ ", department_name=" + department_name + "]";
	}
	
	
}
