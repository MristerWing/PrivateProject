package com.gmx0807.reactivejava.chapter02;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.Observable;


public class OservableFormFuture {

	public void emit() {
		
		Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
			Thread.sleep(1000);
			return "Hello Future";
		});
		
		Observable<String> source = Observable.fromFuture(future);
		source.subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		OservableFormFuture demo = new OservableFormFuture();
		demo.emit();
	}
}
