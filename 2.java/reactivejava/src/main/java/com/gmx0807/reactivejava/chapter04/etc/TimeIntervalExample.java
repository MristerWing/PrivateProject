package com.gmx0807.reactivejava.chapter04.etc;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.schedulers.Timed;

/*값을 발행했을 때 이전 값을 발행한 이후 
얼마나 시간이 흘렀는지 알려주는 함수*/

public class TimeIntervalExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] data = {"RED", "GREEN", "ORANGE"};
		
		CommonUtils.exampleStart();
		Observable<Timed<String>> source = Observable.fromArray(data)
				.delay(item -> {
					CommonUtils.doSomething();
					return Observable.just(item);
				})
				.timeInterval();
		
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		TimeIntervalExample demo = new TimeIntervalExample();
		demo.marbleDiagram();
	}

}
