package com.gmx0807.reactivejava.chapter03;

import io.reactivex.*;
import io.reactivex.functions.Function;
import io.reactivex.Observable;

import com.gmx0807.reactivejava.common.*;

public class MapExample {
	
	public void emit() {
		String[] balls = {"1", "2", "3", "5"};
		Observable<String> source = Observable.fromArray(balls)
				.map(ball -> ball + "◇");
		source.subscribe(Log::i);
	}
	
	public void functionInterface() {
		Function<String, String> getDiamond = ball -> ball + "◇";
		
		String[] balls = {"1", "2", "3", "5"};
		Observable<String> source = Observable.fromArray(balls)
				.map(getDiamond);
		source.subscribe(Log::i);
	}
	
	public void mappingType() {
		Function<String, Integer> ballToIndex = ball -> {
			switch(ball) {
			case"RED": return 1;
			case"YELLOW": return 2;
			case"GREEN": return 3;
			case"BLUE": return 5;
			default: return -1;
			}
		};
		
		String[] balls = {"YELLOW", "GREEN", "BLUE", "RED"};
		Observable<Integer> source = Observable.fromArray(balls)
				.map(ballToIndex); //명시변환 없이 바로 사용가능
		source.subscribe(Log::i);
	}

	public static void main(String[] args) {
		MapExample demo = new MapExample();
		demo.emit();
		CommonUtils.exampleComplete();
		demo.functionInterface();
		CommonUtils.exampleComplete();
		demo.mappingType();
		
	}

}
