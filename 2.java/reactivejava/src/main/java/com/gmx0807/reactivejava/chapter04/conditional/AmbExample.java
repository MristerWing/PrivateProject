package com.gmx0807.reactivejava.chapter04.conditional;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;
import static com.gmx0807.reactivejava.common.Shape.rectangle;

/* amb: ambiguous(모호한)라는 영단어의 줄임말. 여러개의 Observable 중
 * 1개의 Observable을 선택하는데, 선택하는 기준은 
 * 가장 먼저 데이터를 발행하는 Observable이다.
 * 이후 나머지 Observable에서 발행하는 데이터는 모두 무시한다.*/

public class AmbExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] data1 = {RED, GREEN, BLUE};
		String[] data2 = {rectangle(YELLOW), rectangle(SKY)};
		
		List<Observable<String>> sources = Arrays.asList(
				Observable.fromArray(data1)
					.doOnComplete(() -> Log.d("Observable #1: onComplete()")),
				Observable.fromArray(data2)
				.delay(100L, TimeUnit.MILLISECONDS)
				.doOnComplete(() -> Log.d("Observable #2: onComplete()")));
		
		Observable.amb(sources)
		.doOnComplete(() -> Log.d("Result: onComplete"))
				.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
		
	}

	public static void main(String[] args) {
		AmbExample demo = new AmbExample();
		demo.marbleDiagram();
	}

}
