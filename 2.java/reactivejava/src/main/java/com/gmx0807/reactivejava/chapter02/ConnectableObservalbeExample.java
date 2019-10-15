package com.gmx0807.reactivejava.chapter02;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import com.gmx0807.reactivejava.common.*;


public class ConnectableObservalbeExample {

	public void emit() {
		String[] dt = {"1", "3", "5"};
				Observable<String> balls = Observable.interval(100, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(i -> dt[i])
				.take(dt.length);
				
		ConnectableObservable<String> source = balls.publish();
		source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		source.connect();
		
		CommonUtils.sleep(250);
		source.subscribe(data -> System.out.println("Subscriber #3 => " + data));
		CommonUtils.sleep(100);
	}
	
	public static void main(String[] args) {
		ConnectableObservalbeExample demo = new ConnectableObservalbeExample();
		demo.emit();

	}

}
