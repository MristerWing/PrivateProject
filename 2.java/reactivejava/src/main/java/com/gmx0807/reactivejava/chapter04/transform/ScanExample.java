package com.gmx0807.reactivejava.chapter04.transform;

import com.gmx0807.reactivejava.common.MarbleDiagram;

import io.reactivex.Observable;
import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

public class ScanExample implements MarbleDiagram {

	public void marbleDiagram() { 
		/*
		 * reduce와 비슷하지만 모든 데이터를 종합하기 전에 
		 * 중간에 종합한 값을 반환함
		 * reduce는 마지막 값이 입력이 안되거나, onComplete가 발생이
		 * 안될 수도 있기에 Maybe함수를 사용하지만, scan은 중간 값을 
		 * 모두 발행하기 때문에 Observalbe을 사용함
		 */
		
		String[] balls = {RED, GREEN, BLUE}; //1,3,5
		Observable<String> source = Observable.fromArray(balls)
				.scan((ball1, ball2) -> ball2 + "(" + ball1 + ")");
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	
	/*
	 * 결과값을 보면 reduce의 경우 완료된 5(3(1)) 값만을 발행하지만, 
	 * scan은 그 중간 값과 최종값인 1 3(1) 5(3(1))을 모두 발행함
	 */
	public static void main(String[] args) {
		ScanExample demo = new ScanExample();
		demo.marbleDiagram();
	}

}
