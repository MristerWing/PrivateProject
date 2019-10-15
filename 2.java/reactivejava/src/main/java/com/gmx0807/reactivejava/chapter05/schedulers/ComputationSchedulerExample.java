package com.gmx0807.reactivejava.chapter05.schedulers;

import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

/*
 * 계산 스케줄러는 CPU에 대응하는 계산용 스케줄러이다.
 * 계산 작업을 수행할 때에는 대기 시간 없이 빠르게 
 * 결과를 도출하는 것이 중요하다.
 * 입출력(I/O)작업 없이 수행하는 스케줄러이다.
 * 내부적으로 ThreadPool을 생성하며 
 * 스레드의 갯수는 기본적으로 프로세서의 갯수와 동일하다.*/

/*
 * 예제의 값이 ThreadPool을 할당하여 다른 Thread로 동작하지만,
 * 거의 같은 시간에 데이터가 발행되기 때문에 같은 Thread에서 동작될 수 있다.*/

public class ComputationSchedulerExample {
	
	public void basic() {
		String[] orgs = {RED, GREEN, BLUE};
		
		Observable<String> source = Observable.fromArray(orgs)
				.zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (a,b) -> a);
		
		//Subscripion #1
		source.map(item -> "<<" + item + ">>")
		.subscribeOn(Schedulers.computation())
		.subscribe(Log::i);
		
		//Subscripion #2
		source.map(item -> "##" + item + "##")
		.subscribeOn(Schedulers.computation())
		.subscribe(Log::i);
		
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		ComputationSchedulerExample demo = new ComputationSchedulerExample();
		demo.basic();
	}

}
