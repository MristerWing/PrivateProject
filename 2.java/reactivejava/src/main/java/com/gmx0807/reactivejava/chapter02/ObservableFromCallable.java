package com.gmx0807.reactivejava.chapter02;

import java.util.concurrent.*;

import io.reactivex.Observable;

public class ObservableFromCallable implements Callable<String> {

	public void emit() {

//		Lambda
		Callable<String> callable = () -> {
			Thread.sleep(1000);
			return "Hello Callable";
		};

		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
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

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "error";
	}

}
