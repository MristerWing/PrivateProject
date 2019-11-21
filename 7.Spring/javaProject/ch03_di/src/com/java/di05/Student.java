package com.java.di05;

public class Student {
	private String name;
	private String age;
	private String gradName;
	private String className;

	public Student() {
		super();
	}

	public Student(String name, String age, String gradName, String className) {
		super();
		this.name = name;
		this.age = age;
		this.gradName = gradName;
		this.className = className;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setGradName(String gradName) {
		this.gradName = gradName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gradName="
				+ gradName + ", className=" + className + "]";
	}

}
