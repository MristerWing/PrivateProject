package com.java.di06;

import java.util.HashMap;
import java.util.Iterator;

public class StudentInfo {
	private HashMap<String, Student> studentMap;

	public StudentInfo() {
		super();
	}

	public StudentInfo(HashMap<String, Student> studentMap) {
		super();
		this.studentMap = studentMap;
	}

	public void setStudentList(HashMap<String, Student> studentMap) {
		this.studentMap = studentMap;
	}

	public void print() {
		Iterator<String> studentIterator = studentMap.keySet().iterator();

		while (studentIterator.hasNext()) {
			String key = studentIterator.next();

			Student student = studentMap.get(key);
			System.out.println(student.toString());
		}
	}

}
