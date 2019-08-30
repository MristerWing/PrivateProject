package com.gmx0807.reactivejava.chapter03;

import io.reactivex.Observable;
import io.reactivex.Maybe;
import io.reactivex.functions.BiFunction;

import com.gmx0807.reactivejava.common.CommonUtils;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

/*reduce: 감소하다?
 * ball1, ball2를 가지고 ball2(ball1)의 형식으로 리턴
 * 이후 완료될 때까지 리턴값3(1)을 ball1으로 인식,
 * ball2(3(1))형식으로 만듬. 이후 완료되면 완료된 값을 리턴*/


public class ReduceExample {
	
	public void marbleDiagram() {
		String[] balls = {RED, GREEN, BLUE}; //1, 3, 5
		Maybe<String> source = Observable.fromArray(balls)
				.reduce((ball1, ball2) -> ball2 + "(" + ball1 + ")");
		source.subscribe(System.out::println);
		CommonUtils.exampleComplete();
	}
	
	public void BiFunction() {
		BiFunction<String, String, String> mergeBalls =
				(ball1, ball2) ->  ball2 + "(" + ball1 + ")";
				
		String[] balls = {RED, GREEN, BLUE};
		Maybe<String> source = Observable.fromArray(balls)
				.reduce(mergeBalls);
		source.subscribe(System.out::println);
		CommonUtils.exampleComplete();
	}
	
	public void Test() {
		String[] balls = {RED, GREEN, BLUE, "7", "8", "9"};
		Maybe<String> source = Observable.fromArray(balls)
				.reduce((ball1, ball2) -> ball2 + "☆" + ball1 + "★");
		source.subscribe(System.out::println);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		ReduceExample demo = new ReduceExample();
		demo.marbleDiagram();
		demo.BiFunction();
		demo.Test();

	}

}
