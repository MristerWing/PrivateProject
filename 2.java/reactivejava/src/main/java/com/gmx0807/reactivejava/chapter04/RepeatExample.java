package com.gmx0807.reactivejava.chapter04;

import io.reactivex.Observable;

import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.RED;

import java.util.concurrent.TimeUnit;

import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

public class RepeatExample implements MarbleDiagram {
	
	/* repeat함수, 단순한 반복을 실행한다. 
	 * 인자를 입력하지 않으면 영원히 반복한다.*/
	
	@Override
	public void marbleDiagram() {
		String[] balls = {RED, GREEN, BLUE};
		Observable<String> source = Observable.fromArray(balls)
				.repeat(3);
		
		//doOnComplete = log 출력
		source.doOnComplete(() -> Log.d(("onComplete")))
		.subscribe(Log::i);
		CommonUtils.exampleComplete();
		}
	
	public void heartbeatV1() {
		CommonUtils.exampleStart();
		String serverUrl = "https://api.github.com/zen";
		
		//2초간격으로 핑을 날림
		Observable.timer(2, TimeUnit.SECONDS)
		.map(val -> serverUrl)
		.map(OkHttpHelper::get)
		.repeat()
		.subscribe(res -> Log.it("Ping Result: " + res));
		CommonUtils.sleep(10000);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		RepeatExample demo = new RepeatExample();
		//demo.marbleDiagram(); //repeat run
		demo.heartbeatV1();
	}

}
