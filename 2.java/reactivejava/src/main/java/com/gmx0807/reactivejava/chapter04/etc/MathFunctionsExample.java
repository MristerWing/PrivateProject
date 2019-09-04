package com.gmx0807.reactivejava.chapter04.etc;

import com.gmx0807.reactivejava.common.MarbleDiagram;
import com.gmx0807.reactivejava.common.Log;

import hu.akarnokd.rxjava3.math.MathFlowable;
import io.reactivex.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class MathFunctionsExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		Integer[] data = {1, 2, 3, 4};
		
		//1. count
		Single<Long> source = Observable.fromArray(data)
				.count();
		source.subscribe(count -> Log.i("count is " + count));
		
		//2.max() min()
		Flowable.fromArray(data)
		.to(MathFlowable::max)						//to: 다른 타입으로 변환시켜 주기 위한 함수
		.subscribe(max -> Log.i("Max is " + max));

		Flowable.fromArray(data)
		.to(MathFlowable::min)
		.subscribe(min -> Log.i("Min is " + min));
		
		//sum() average
		Flowable<Integer> flowable = Flowable.fromArray(data)
				.to(MathFlowable::sumInt);
		flowable.subscribe(sum -> Log.i("sum is " + sum));
		
		Flowable<Double> flowable2 = Observable.fromArray(data)
				.toFlowable(BackpressureStrategy.BUFFER)		//toFlowable: Observable을 Flowable로 변환해주는 함수
				.to(MathFlowable::averageDouble);				//배압
		flowable2.subscribe(avg -> Log.i("avg is " + avg));
		
		
	}
	
	public static void main(String[] args) {
		MathFunctionsExample demo = new MathFunctionsExample();
		demo.marbleDiagram();

	}

}
