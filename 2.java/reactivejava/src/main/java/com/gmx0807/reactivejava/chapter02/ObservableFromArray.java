package com.gmx0807.reactivejava.chapter02;

import io.reactivex.Observable;

public class ObservableFromArray {
	
	public void emit() {
		Integer[] arr = {100, 200, 300};
		Observable<Integer> source = Observable.fromArray(arr);
		source.subscribe(System.out::println);
	}
	
	public static void main(String arg[]) {
		ObservableFromArray demo = new ObservableFromArray();
		demo.emit();
	}
}
