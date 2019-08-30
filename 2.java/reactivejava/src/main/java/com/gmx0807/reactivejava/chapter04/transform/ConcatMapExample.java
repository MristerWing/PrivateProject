package com.gmx0807.reactivejava.chapter04.transform;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

import com.gmx0807.reactivejava.common.*;

public class ConcatMapExample implements MarbleDiagram{

	//cocatMap을 이용하여 interleving(끼어들기)방지
	public void marbleDiagram() {
		TimeUnit unit = TimeUnit.MILLISECONDS; 
		CommonUtils.exampleStart(); //시간 측정을 위하여 호출
		
		String[] balls = {RED, GREEN, BLUE};
		Observable<String> source = Observable.interval(100L, unit)
				.map(Long::intValue)
				.map(idx -> balls[idx])
				.take(balls.length)
				.concatMap(
						ball -> Observable.interval(200L, unit)
						.map(notUsed -> ball + "<>")
						.take(2)); //2개의 다이아몬드
		
		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
		CommonUtils.exampleComplete();
	}
	
	//concatMap 대신 flatMap을 사용
	public void interleaving() { 
		CommonUtils.exampleStart(); //시간을 측정하기 위해 호출
		
		String[] balls = {RED, GREEN, BLUE};
		Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> balls[idx])
				.take(3)
				.flatMap(
					ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
									.map(notUsed -> ball + "<>")
									.take(2));
		source.subscribe(Log::it);
		CommonUtils.sleep(2000);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		ConcatMapExample demo = new ConcatMapExample();
		
		/* 결과를 보면 interleaving을 방지하려면 더 많은 시간을 
		 * 투자해야한다는 것을 알 수 있다. */
		
		demo.marbleDiagram();
		demo.interleaving();

	}

}
