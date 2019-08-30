package com.gmx0807.reactivejava.chapter04;

import com.gmx0807.reactivejava.common.*;
import io.reactivex.Observable;

/*range로 for를 대체, filter로 if문을 대체*/


public class RangeExample {

	public void forLoop() {
		/*
		 * 1 ~10까지의 값을 지정하여 돌리면서 지정된 조건함수를 
		 * 만족하면 그 값을 취한다.
		 * 현제 스레드에서 동작하기 때문에 sleep를 호출하지 않는다.
		 */
		
		Observable<Integer> source = Observable.range(1, 10) //for
				.filter(number -> number % 2 == 0);			 //if
		
		source.subscribe(Log::it);
	}
	
	public static void main(String[] args) {
		RangeExample demo = new RangeExample();
		demo.forLoop();

	}

}
