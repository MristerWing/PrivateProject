package com.gmx0807.reactivejava.chapter04.etc;

import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.ORANGE;

/* delay: 시간을 인자로 전달받아서 
 * 유틸리티 연산자로서 보조하는 역할
 * 인자로 전달받는 time과 시간단위(ms, s등)만큼 
 * 입력받은 Observable의 데이터 발행을 지연시켜주는 역할을 한다.
 * 지연된 데이터는 동일한 시간에 발행된다.*/

public class DelayExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		CommonUtils.exampleStart();
		
		String[] data = {RED, ORANGE, YELLOW, GREEN, SKY};
		Observable<String> source = Observable.fromArray(data)
				.delay(100L, TimeUnit.MILLISECONDS);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		DelayExample demo = new DelayExample();
		demo.marbleDiagram();
	}

}
