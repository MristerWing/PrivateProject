package com.gmx0807.reactivejava.chapter02;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class ObservableCeateExample {
	
	public void emit() {
		Observable<Integer> source = Observable.create(
				(ObservableEmitter<Integer> emitter) -> {
					emitter.onNext(100);
					emitter.onNext(200);
					emitter.onNext(300);
					emitter.onComplete();
				});
		
		//data는 변수의 이름이므로 원하는 변수명으로 기입
		
		/* 익명객체
		 * source.subscribe(new Consumer<Integer>() {
		 * 
		 * @Override public void accept(Integer data) throws Exception {
		 * System.out.printIn("Result : " + data); } });
		 */
		
		//람다식
		//source.subscribe(data -> System.out.println("Result : " + data)); 
		
		//System.out::println 같은 형태를 메서드 레퍼런스라고함
		source.subscribe(System.out::println);
	}

	public static void main(String[] args) {
		ObservableCeateExample demo = new ObservableCeateExample();
		demo.emit();

	}

}
