package com.java.aop01;

public class PersonAspect {
	private Person person;

	public PersonAspect(Person person) {
		this.person = person;
	}

	public void advice() {
		this.wakeUp();
		person.work();
		this.sleep();
	}

	public void wakeUp() {
		System.out.println(person.getClass().getName() + "가 일어났습니다!");
	}

	public void sleep() {
		System.out.println(person.getClass().getName() + "가 잠이듭니다.zzzz");
	}

}
