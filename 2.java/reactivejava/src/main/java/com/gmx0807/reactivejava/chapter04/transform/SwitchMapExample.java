package com.gmx0807.reactivejava.chapter04.transform;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

import com.gmx0807.reactivejava.common.*;

public class SwitchMapExample implements MarbleDiagram{
	
	public void marbleDiagram() {
		CommonUtils.exampleStart(); //시간측정을 위하여 호출
		
		String[] balls = {RED, GREEN, BLUE};
		Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> balls[idx])
				.take(balls.length)
				.switchMap(
						ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
						.map(notUsed -> ball + "<>")
						.take(2));
		
		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
		CommonUtils.exampleComplete();
				
	}
	
	public void usingDoOnNext() {
CommonUtils.exampleStart(); //시간측정을 위하여 호출
		
		String[] balls = {RED, GREEN, BLUE};
		Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> balls[idx])
				.take(balls.length)
				.doOnNext(Log::dt)
				.switchMap(
						ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
						.map(notUsed -> ball + "<>")
						.take(2));
		
		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		SwitchMapExample demo = new SwitchMapExample();
		
		demo.marbleDiagram();
		demo.usingDoOnNext();

	}

}
