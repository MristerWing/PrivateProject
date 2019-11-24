package com.java.quiz02;

import java.util.HashMap;

/**
 * @author KimJinsu
 * @Date 2019. 11. 21.
 * @Infomation 학생
 */

public class Student {
	private String name;
	private HashMap<String, Float> grades;
	/*
	 * private float language; private float english; private float math;
	 */

	public Student() {
	}

	public Student(String name, HashMap<String, Float> grades) {
		this.name = name;
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Float> getGrades() {
		return grades;
	}

	public void setGrades(HashMap<String, Float> grades) {
		this.grades = grades;
	}

}
