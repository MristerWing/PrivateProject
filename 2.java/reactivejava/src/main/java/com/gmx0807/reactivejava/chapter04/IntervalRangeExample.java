package com.gmx0807.reactivejava.chapter04;

import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.CommonUtils;
import com.gmx0807.reactivejava.common.Log;

import io.reactivex.Observable;

public class IntervalRangeExample {
	public void printNumbers() { 
		Observable<Long> source = Observable.intervalRange(1, //start 
				5, 						//count
				100L ,					//intialDelay
				100L, 					//period
				TimeUnit.MILLISECONDS);	//unit
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	public void makeWithInterval() { 
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(val -> val + 1)
				.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();		
	}
	
	
	public static void main(String[] args) { 
		IntervalRangeExample demo = new IntervalRangeExample();
		demo.printNumbers();
		demo.makeWithInterval();
	}
}
