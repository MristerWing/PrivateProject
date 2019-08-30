package com.gmx0807.reactivejava.chapter04.transform;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

import java.util.concurrent.TimeUnit;

import static com.gmx0807.reactivejava.common.Shape.PUPPLE;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.triangle;

import com.gmx0807.reactivejava.common.*;

public class GroupByExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] objs = {PUPPLE, SKY, triangle(YELLOW), YELLOW, triangle(PUPPLE), triangle(SKY)};
		
		//함수를 입력받는다. 입력 받은 값을 기준으로 다수의 그룹화된 새로운 Observable을 생성함
		Observable<GroupedObservable<String, String>> source =
				Observable.fromArray(objs)
				.groupBy(Shape::getShape);
		
		source.subscribe(obj -> {obj.subscribe(val ->
				System.out.println("GROUP: " + obj.getKey() + "\t Value: " + val));
			});
		
		CommonUtils.exampleComplete();
	}
	
	public void filterBallGroup() {
		String[] objs = {PUPPLE, SKY, triangle(YELLOW), YELLOW, triangle(PUPPLE), triangle(SKY)};
		Observable<GroupedObservable<String, String>> source =
				Observable.fromArray(objs)
				.groupBy(Shape::getShape);
		
		source.subscribe(obj -> {
			obj.filter(val -> obj.getKey().equals(Shape.BALL))
			.subscribe(val ->
				System.out.println("GROUP: " + obj.getKey() + "\t Value: " + val));
			});
		
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		GroupByExample demo = new GroupByExample();
		demo.marbleDiagram();
		demo.filterBallGroup();

	}

}
