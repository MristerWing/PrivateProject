package com.gmx0807.reactivejava.chapter05;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;		//스케줄러

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.star;
import static com.gmx0807.reactivejava.common.Shape.triangle;
import static com.gmx0807.reactivejava.common.Shape.pentagon;

/*
 * 1. 스케줄러는 RxJava 코드를 어느 스레드에서 실행할지 지정할 수 있다.
 * 2. subscribeOn() 함수와 observeOn() 함수를 모두 지정하면 
 * Observable에서 데이터 흐름이 발생하는 스레드와 처리된 결과를 구독자에게
 * 발행하는 스레드를 분리할 수 있다.
 * 3. subscribeOn() 함수만 호출하면 Observable우ㅏ 모든 흐름이 동일한 스레드에서 실행된다.
 * 4. 스케줄러를 별도로 지정하지 않으면 현제(main)스레드에서 동작을 실행한다.
 * */

public class FilpExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] objs = {star(RED), triangle(YELLOW), pentagon(GREEN)};
		
		Observable<String> source = Observable.fromArray(objs)
				.doOnNext(data -> Log.v("Original data = " + data))		//doOnNext가 실행되어 원래의 데이터 값을 확인
				.subscribeOn(Schedulers.newThread())					//구독자가 Observable에 subscribe() 함수를 호출하여 구독할 때 실행되는 스레드를 지정
				.observeOn(Schedulers.newThread())						//Observable에 subscribe()함수를 호출하여 구독할 때 실행되는 스레드를 지정, newThread로 새 스레드 생성
				.map(Shape::flip);
	
		source.subscribe(Log::i);
		CommonUtils.sleep(500);
		CommonUtils.exampleComplete();
	}
	
	public void oberveOnRemove() {
		String[] objs = {star(RED), triangle(YELLOW), pentagon(GREEN)};
		
		Observable<String> source = Observable.fromArray(objs)
				.doOnNext(data -> Log.v("Original data = " + data))
				.subscribeOn(Schedulers.newThread())
//				.remove.observeOn(Schedulers.newThread())
				.map(Shape::flip);
		
		source.subscribe(Log::i);
		CommonUtils.sleep(500);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		FilpExample demo = new FilpExample();
		demo.marbleDiagram();
	}

}
