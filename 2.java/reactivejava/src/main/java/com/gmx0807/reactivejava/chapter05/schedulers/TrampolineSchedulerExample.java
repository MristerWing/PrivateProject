package com.gmx0807.reactivejava.chapter05.schedulers;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/*
 * 새로운 thread를 생성하지 않고 현제thread에 
 * 무한한 크기의 대기행렬(Queue)을 생성하는 스케줄러
 * */

public class TrampolineSchedulerExample {

	public void run() {
		String[] orgs = { "RED", "GREEN", "BLUE" };
		Observable<String> source = Observable.fromArray(orgs);

		// Subscription #1
		source.subscribeOn(Schedulers.trampoline()).map(data -> "<<" + data + ">>").subscribe(Log::i);

		// Subscription #2
		source.subscribeOn(Schedulers.trampoline()).map(data -> "##" + data + "##").subscribe(Log::i);
		
		CommonUtils.sleep(500);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		TrampolineSchedulerExample demo = new TrampolineSchedulerExample();
		demo.run();
	}

}
