package com.gmx0807.reactivejava.chapter05.examples;

import com.gmx0807.reactivejava.common.CommonUtils;
import com.gmx0807.reactivejava.common.Log;
import com.gmx0807.reactivejava.common.OkHttpHelper;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.gmx0807.reactivejava.common.CommonUtils.GITHUB_ROOT;

/*
 * 비동기식 선언의 장점
 * 1. 선언적 동시성. 순수한 비즈니스로직과 비동기 동작을 위한 스레드 부분을 구별할 수 있도록함.
 * 2. 가독성. 정상적인 로직과 향후 예외처리 부분을 말끔하게 분리할 수 있도록 함
 */

public class CallbackHaven {
	
	private static final String FIRST_URL = "https://api.github.com/zen";
	private static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_heaven";

	public void usingConcat() {
		CommonUtils.exampleStart();
		Observable<String> source = Observable.just(FIRST_URL)
				.subscribeOn(Schedulers.io()) //IO스케줄러를 통해 별도의 스레드에서 네트워크를 호출
				.map(OkHttpHelper::get) //OkHttpHelper.get()에서 OkHttpClient의 execute()를 호출
				//concatWith은 concat과 동일하게 작동한다. 다만 concatWith은 현재의 Observable에 새로운 Observable을 추가한다. 
				.concatWith(Observable.just(SECOND_URL)			
						.map(OkHttpHelper::get));
		
		source.subscribe(Log::it);
		CommonUtils.sleep(5000);
		CommonUtils.exampleComplete();
		
	}
	
	//concat은 척번쨰 Observable에서 데이터 발행이 끝날 때까지 기다려야함.
	//zip를 이용할 경우 첫번째 URL과 두번째 URL요청을 동시에 수행하고 결과만 결합하기 때문에 성능향상을 기대할 수 있음.
	public void usingZip() {
		
		//중요한것은 Observable을 2개로 나눈다는 것을 생각하는것
		//첫 URL과 두번째 URL을 각각의 Observable로 할당한 뒤 zip로 동시에 실행함.
		CommonUtils.exampleStart();
		Observable<String> first = Observable.just(FIRST_URL)
				.subscribeOn(Schedulers.io())
				.map(OkHttpHelper::get);
		Observable<String> second = Observable.just(SECOND_URL)
				.subscribeOn(Schedulers.io())
				.map(OkHttpHelper::get);
		
		Observable.zip(first, second,
				(a, b) -> ("\n>>" + a + "\n>>" + b))
		.subscribe(Log::it);
		
		CommonUtils.sleep(5000);
		
	}
	
	public static void main(String[] args) {
		CallbackHaven demo = new CallbackHaven();
		
//		demo.usingConcat();
		demo.usingZip();
	}

}
