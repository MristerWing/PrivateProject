package com.gmx0807.reactivejava.chapter04;

import java.util.Arrays;
import java.util.Iterator;

import java.util.concurrent.Callable;

import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;
import static com.gmx0807.reactivejava.common.Shape.PUPPLE;

import io.reactivex.Observable;

public class DeferExample implements MarbleDiagram {
	
	Iterator<String> colors = Arrays.asList(RED, GREEN, BLUE, PUPPLE).iterator();
	
	
	@Override
	public void marbleDiagram() {
		Callable<Observable<String>> supplier = () -> getObservable();
		Observable<String> source = Observable.defer(supplier);
		
		source.subscribe(val -> Log.i("Subscriber #1: " + val));
		source.subscribe(val -> Log.i("Subscriber #2: " + val));
		CommonUtils.exampleComplete();
		
	}
	
	//번호가 적힌 도형을 발행하는 Observable을 생성
	private Observable<String> getObservable() {
		if (colors.hasNext()) {
			String color = colors.next();
			return Observable.just(
					Shape.getString(color, Shape.BALL),
					Shape.getString(color, Shape.RECTANGLE),
					Shape.getString(color, Shape.PENTAGON));
		}
		
		return Observable.empty();
	}
	
	public void notDeferred() {
		Observable<String> source = getObservable();
		
		source.subscribe(val -> Log.i("Subscriber #1: " + val));
		source.subscribe(val -> Log.i("Subscriber #2: " + val));
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		DeferExample demo = new DeferExample();
		demo.marbleDiagram();
		demo.notDeferred();

	}

	

}
