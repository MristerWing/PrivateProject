package com.gmx0807.reactivejava.chapter05.schedulers;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/*
 * RxJava내부에서 단일 스레드를 
 * 별도로 생성하여 구독 작업을 처리하는 함수
 * */

public class SingleSchedulerExample {

	public void basic() {
		Observable<Integer> numbers = Observable.range(100, 5);
		Observable<String> chars = Observable.range(0, 5).map(CommonUtils::numberToAlphabet);

		numbers.subscribeOn(Schedulers.single()).subscribe(Log::i);
		chars.subscribeOn(Schedulers.single()).subscribe(Log::i);

		CommonUtils.sleep(500);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		SingleSchedulerExample demo = new SingleSchedulerExample();
		demo.basic();
	}

}
