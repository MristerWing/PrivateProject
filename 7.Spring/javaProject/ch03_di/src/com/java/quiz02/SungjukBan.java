package com.java.quiz02;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author KimJinsu
 * @Date 2019. 11. 21.
 * @Infomation 학생종합정보
 * @see com.java.quiz02.Student
 */
public class SungjukBan {
	private ArrayList<Student> studentList;

	public SungjukBan() {
	}

	public SungjukBan(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void banDisp() {
		DecimalFormat floatFormat = new DecimalFormat("0.##");
		HashMap<String, Float> studentGrades = null;

		float sum = 0f;
		for (Student student : studentList) {
			studentGrades = student.getGrades();
			Iterator<String> studentGradesIter = studentGrades.keySet()
					.iterator();

			while (studentGradesIter.hasNext()) {
				String key = studentGradesIter.next();
				sum += studentGrades.get(key);
			}
		}

		float average = 0f;
		float countOfStudentGrades = studentList.size() * studentGrades.size();
		average = sum / countOfStudentGrades;

		System.out.println("반총점:" + floatFormat.format(sum) + " 반평균:"
				+ floatFormat.format(average));
	}
}
