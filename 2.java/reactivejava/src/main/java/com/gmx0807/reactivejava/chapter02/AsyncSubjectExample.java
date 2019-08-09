package com.gmx0807.reactivejava.chapter02;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.Observable;

public class AsyncSubjectExample {

	public void emit() {
		AsyncSubject<String> subject = AsyncSubject.create();
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		subject.onNext("5");
		subject.onComplete();
		
//		�����ڷ� �����ϴ� AsyncSubject
		Float[] temperature = {10.1f, 13.4f, 12.5f};
		Observable<Float> source = Observable.fromArray(temperature);
		
		AsyncSubject<Float> subject2 = AsyncSubject.create();
		subject2.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		
		source.subscribe(subject2);
		
	}
	
	public static void main(String[] args) {
		AsyncSubjectExample demo = new AsyncSubjectExample();
		demo.emit();
	}

}
