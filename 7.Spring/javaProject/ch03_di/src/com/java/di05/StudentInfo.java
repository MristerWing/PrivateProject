package com.java.di05;

import java.util.ArrayList;

public class StudentInfo {
	private ArrayList<Student> studentList;

	public StudentInfo() {
		super();
	}

	public StudentInfo(ArrayList<Student> studentList) {
		super();
		this.studentList = studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void print() {
		for (Student index : studentList) {
			System.out.println(
					studentList.indexOf(index) + "\t" + index.toString());
		}
	}
}
