package com.gmx0807.reactivejava.chapter04;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import com.gmx0807.reactivejava.common.*;

/*일정간격으로 데이터의 흐름을 생성하는 함수
 * 주어진 시간으로부터 0부터 1씩 증가하는 Long 객체를 발행
 * range = for
 * interval = 스레드 딜레이를 주는 for*/

public class IntervalExample {
	
	/*
	 * 100ms간격으로 0부터 데이터를 발행한 후 map()함수를 호출하여 
	 * 입력값에1을 더한 뒤 100을 곱하는 함수
	 */
	public void printNumbers() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(data -> (data + 1) * 100)
				.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	
//	딜레이제거
	public void noInitialDelay() {
		CommonUtils.exampleStart();
		Observable<Long> source = Observable.interval(0L, 100L, TimeUnit.MICROSECONDS)
				.map(val -> val + 100)
				.take(5);
		
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		IntervalExample demo = new IntervalExample();
		demo.printNumbers();
		demo.noInitialDelay();

	}

}
