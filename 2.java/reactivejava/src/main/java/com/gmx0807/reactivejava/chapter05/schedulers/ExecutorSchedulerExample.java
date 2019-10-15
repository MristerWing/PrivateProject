package com.gmx0807.reactivejava.chapter05.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import com.gmx0807.reactivejava.common.*;

/*
 * java에서 제공하는 실행자(executor)를 변환하여 
 * 스케줄러를 생성하는 방법
 * 하지만 executor과 스케줄러의 동작방식이 다르므로 추천하는 방식은 아니다.
 * 기존에 사용하던 Executor클래스를 재사용할 때에만 사용한다.
 * */

public class ExecutorSchedulerExample {

	public void run() {
		final int THREAD_NUM = 10; //executor은  고정 10개의 Thread-pool을 생성한다.

		String[] data = { "RED", "GREEN", "BLUE" };
		Observable<String> source = Observable.fromArray(data);
		Executor executor = Executors.newFixedThreadPool(THREAD_NUM);

		source.subscribeOn(Schedulers.from(executor)).subscribe(Log::i);
		source.subscribeOn(Schedulers.from(executor)).subscribe(Log::i);
		
		CommonUtils.sleep(500);
		CommonUtils.exampleComplete();

	}

	public static void main(String[] args) {
		ExecutorSchedulerExample demo = new ExecutorSchedulerExample();
		demo.run();
	}

}
