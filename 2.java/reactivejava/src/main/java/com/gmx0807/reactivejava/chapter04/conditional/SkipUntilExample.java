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

/* takeUntil()함수의 정 반대 함수이다.
 * other Observable을 인자로 받는다는 점은 같지만 
 * Observable에서 데이터를 발행할때까지 값을 건너 뛴다.*/ 

public class SkipUntilExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] data = {RED, YELLOW, GREEN, SKY, BLUE, PUPPLE};
		
		Observable<String> source = Observable.fromArray(data)
				.zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS),
						(val, notUsed) -> val)
				.skipUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));
		
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
		
	}
	
	public static void main(String[] args) {
		SkipUntilExample demo = new SkipUntilExample();
		demo.marbleDiagram();

	}

}
