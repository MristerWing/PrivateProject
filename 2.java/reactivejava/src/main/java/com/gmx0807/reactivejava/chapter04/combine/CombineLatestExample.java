package com.gmx0807.reactivejava.chapter04.combine;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.PUPPLE;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.ORANGE;
import static com.gmx0807.reactivejava.common.Shape.PENTAGON;
import static com.gmx0807.reactivejava.common.Shape.STAR;
import static com.gmx0807.reactivejava.common.Shape.DIAMOND;
//import static com.gmx0807.reactivejava.common.Shape.GREEN;
//import static com.gmx0807.reactivejava.common.Shape.BLUE;

//zip과 동일하나 값이 변경되면 바로 다시 발행하는 함수이다.
public class CombineLatestExample implements MarbleDiagram{

	@Override
	public void marbleDiagram() { 
		String[] data1 = {PUPPLE, ORANGE, SKY, YELLOW}; //6, 7, 4, 2
		String[] data2 = {DIAMOND, STAR, PENTAGON};
		
		Observable<String> source = Observable.combineLatest(
				Observable.fromArray(data1)  
						  .zipWith( //zipWith()로 깔끔하게 코드 정리
						      Observable.interval(100L, TimeUnit.MILLISECONDS), 
							  (shape, notUsed) -> Shape.getColor(shape)),	  
				Observable.fromArray(data2)
				          .zipWith(
				        	  Observable.interval(150L, 200L, TimeUnit.MILLISECONDS),	  
				        	  (shape, notUsed) -> Shape.getSuffix(shape)),
				(v1, v2) -> v1 + v2);
		
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		CombineLatestExample demo = new CombineLatestExample();
		demo.marbleDiagram();

	}

}
