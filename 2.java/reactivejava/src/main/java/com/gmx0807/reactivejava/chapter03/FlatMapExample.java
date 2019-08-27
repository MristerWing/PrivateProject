package com.gmx0807.reactivejava.chapter03;

import com.gmx0807.reactivejava.common.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {

	public void marbleDigram() {
		Function<String, Observable<String>> getDoubleDiamonds = ball -> Observable.just(ball + "¡Þ", ball + "¡Þ");

		String[] balls = { "1", "3", "5" };
		Observable<String> source = Observable.fromArray(balls)
				.flatMap(getDoubleDiamonds);
		source.subscribe(Log::i);
	}

	public static void main(String[] args) {
		FlatMapExample demo = new FlatMapExample();
		
		demo.marbleDigram();
	}

}
