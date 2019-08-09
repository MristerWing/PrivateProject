package com.gmx0807.reactivejava.chapter02;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ObservalbeNotifications {
	public static void main(String arg[]) {
		Observable<String> source = Observable.just("RED", "GREEN", "YELLOW");
		
		Disposable d = source.subscribe(
				v -> System.out.println("onNext() : value : " + v),
					err -> System.out.println("onError() : err : " + err.getMessage()),
					() -> System.out.println("onComplete()")
				);
		
		System.out.println("isDisposed(): " + d.isDisposed());
	}
}
