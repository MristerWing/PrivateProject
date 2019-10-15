package com.gmx0807.reactivejava.chapter04.combine;

import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.functions.Action;

//Action class: doOnComplete()처럼 인자가 없는 람다 표현식을 넣어야 할 때 사용한다.


/*
 * concat은 2개 이상의 Observable을 이어 붙여주는 함수이다.
 * 첫번째 Observable의 onComplete이벤트가 발생해야만
 * 두번째 Observable을 구독한느함수이다.
 */

public class ConcatExample implements MarbleDiagram{

	@Override
	public void marbleDiagram() {
		Action onCompleteAction = () -> Log.d("onComplete()");
		
		String[] data1 = {"RED", "GREEN"}; //1, 3
		String[] data2 = {"YELLOW", "SKY", "PUPPLE"}; //2, 4, 6
		
		Observable<String> source1 = Observable.fromArray(data1)
				.doOnComplete(onCompleteAction);
		Observable<String> source2 = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> data2[idx])
				.take(data2.length)
				.doOnComplete(onCompleteAction);
		
		Observable<String> source = Observable.concat(source1, source2)
				.doOnComplete(onCompleteAction);
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
		
		
	}
	
	public static void main(String[] args) {
		ConcatExample demo = new ConcatExample();
		demo.marbleDiagram();

	}

}
