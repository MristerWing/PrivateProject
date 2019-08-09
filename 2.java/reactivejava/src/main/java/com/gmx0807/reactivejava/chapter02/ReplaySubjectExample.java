package com.gmx0807.reactivejava.chapter02;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {

	public void emit() {
		ReplaySubject<String> subject = ReplaySubject.create();
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		subject.onNext("5");
		subject.onComplete();
	}

	public static void main(String[] args) {
		ReplaySubjectExample demo = new ReplaySubjectExample();
		demo.emit();
	}

}
