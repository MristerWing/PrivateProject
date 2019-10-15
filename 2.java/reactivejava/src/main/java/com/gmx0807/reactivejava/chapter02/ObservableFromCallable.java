package com.gmx0807.reactivejava.chapter02;

import com.gmx0807.reactivejava.common.*;

import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class ObservableFromCallable {

	public void emit() {

//		Lambda
		Callable<String> callable = () -> {
			Thread.sleep(1000);
			return "Hello Callable";
		};

		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
		CommonUtils.exampleComplete();
	}
	
//	not lambda
	/*
	 * Callable<String> callable = new Callable<String>() {
	 * 
	 * @Override public String call() throws Excption { Thread.sleep(100); return
	 * "hello Callable"; } };
	 */

	public static void main(String[] args) {
		ObservableFromCallable demo = new ObservableFromCallable();
		demo.emit();
	}

}
