package com.gmx0807.reactivejava.chapter01;

import io.reactivex.Observable;

public class FirstExample {
	public void emit() {
		/*Observable.just("Hello", "RxJava 2!!")
		.subscribe(System.out::println);*/
		Observable.just(1,  2,  3, 4, 5, 6).subscribe(System.out::println);
	}
	
	public static void main(String args[]) {
		FirstExample demo = new FirstExample();
		demo.emit();
	}
}
