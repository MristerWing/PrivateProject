package com.gmx0807.reactivejava.chapter04.combine;

import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

public class ReactiveSum {

	public static void main(String[] args) {
		new ReactiveSum().run();
	}

	/*
	 * userInput 함수에서 Observable을 만들면 첫번째Observable인 a에서
	 * "a: "라고 입력된 값만 필터링해서 값을 추출한뒤 Integer로 변환한다.
	 * b또한 동일하게 "b: "만 필터링해서 동작한다.
	 * 이후 conbineLatest함수에서 a와b값을 결합한다. 
	 * 결합할때 startWith함수를 사용하는 이유는 commbineLatest함수에서 
	 * 결합하기 위해서는 처음 값을 발행하려면 입력 Observable인 a와b모두에서 
	 * 값을 발행해야 하기 때문이다.
	 * 입력시 바로 값을 확인하기 위해 startWith값을 0으로 초기화 하였다.
	 */
	public void run() {
		ConnectableObservable<String> source = userInput();
		Observable<Integer> a = source
				.filter(str -> str.startsWith("a: "))
				.map(str -> str.replace("a: ",""))
				.map(Integer::parseInt);
		Observable<Integer> b = source
				.filter(str -> str.startsWith("b: "))
				.map(str -> str.replace("b: ", ""))
				.map(Integer::parseInt);
		Observable.combineLatest(
				a.startWith(0), 
				b.startWith(0), 
				(x, y) -> x + y) 
				.skip(1)
				.subscribe(res -> System.out.println("Result: " + res));
		
		source.connect();
	}
	
	public ConnectableObservable<String> userInput() {
		//사용자 콘솔에서 값을 받아온다.
		return Observable.create((ObservableEmitter<String> emitter) -> {
			Scanner in = new Scanner(System.in);
			while(true) {
				System.out.println("Input: ");
				String line = in.nextLine();
				emitter.onNext(line);
				
				//exit입력시 종료
				if(line.indexOf("exit") >= 0) {
					in.close();
					break;
				}
			}
		}).publish();
		
	}
	
}
