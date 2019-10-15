package com.gmx0807.reactivejava.chapter05;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;

public class HelloRxJava2V2 {

	public void emit() {
		Observable.just("Hello", "RxJava 2!!")
		.subscribe(Log::i);
	}

	public static void main(String args[]) {
		HelloRxJava2V2 demo = new HelloRxJava2V2();
		demo.emit();
	}

}
