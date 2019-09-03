package com.gmx0807.reactivejava.chapter04.conditional;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;
import static com.gmx0807.reactivejava.common.Shape.PUPPLE;

/* takeUntil: take()함수에 조건을 설정하는 함수.
 * 인자로 받은 Observable에서 어떤 값을 발행하면 
 * 현재 Observable의 데이터 발행을 중단하고 
 * 즉시완료(onComplete)한다.
 * 즉, take()함수처럼 일정 갯수의 값만을 발행하지만 완료기준을
 * 다른 Observable에서 값을 발행하는지로 판단하는 것이다.
 * 비슷한 함수로는 skipWhile()이 존재*/

public class TakeUntilExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] data = {RED, YELLOW, GREEN, SKY, BLUE, PUPPLE};
		
		//timer를 이용하여 조건식 생성, 500L만큼만 데이터를 발행
		Observable<String> source = Observable.fromArray(data)
				.zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), 
						(val, notUsed) -> val)
				.takeUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));
		
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
		
	}
	
	public static void main(String[] args) {
		TakeUntilExample demo = new TakeUntilExample();
		demo.marbleDiagram();

	}

}
