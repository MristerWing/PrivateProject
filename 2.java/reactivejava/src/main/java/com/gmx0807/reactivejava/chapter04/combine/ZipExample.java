package com.gmx0807.reactivejava.chapter04.combine;

import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;

import static com.gmx0807.reactivejava.common.Shape.PUPPLE;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.BALL;
import static com.gmx0807.reactivejava.common.Shape.PENTAGON;
import static com.gmx0807.reactivejava.common.Shape.STAR;
//import static com.gmx0807.reactivejava.common.Shape.RED;
//import static com.gmx0807.reactivejava.common.Shape.GREEN;
//import static com.gmx0807.reactivejava.common.Shape.BLUE;

import static com.gmx0807.reactivejava.common.Shape.triangle;

/*zip이란 다른 두가지 이상의 Observable을 병합하여 발행하는 함수이다.
 * 최대 9개의 함수를 결합할 수 있다.*/

public class ZipExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] shapes = {BALL, PENTAGON, STAR};
		String[] coloredTriangles = {triangle(YELLOW), triangle(PUPPLE), triangle(SKY)};
		
		Observable<String> source = Observable.zip(
				Observable.fromArray(shapes) //shapes배열을 함수로 발행
				.map(Shape::getSuffix), //Shape의 getSuffix메소들 이용하여 값을 변경함(모양)
				Observable.fromArray(coloredTriangles) //coloredTriangles배열을 함수로 발행
				.map(Shape::getColor), //Shape의 getColor을 이용함(색상)
				(suffix, color) -> color + suffix); //발행된 suffix, color함수를 결함하여 return
		
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	//숫자 결합
	public void zipNumbers() {
		Observable<Integer> source = Observable.zip(
				//just함수를 사용하여 Observable을 발행
				Observable.just(100, 200, 300),
				Observable.just(10, 20, 30),
				Observable.just(1, 2, 3),
				(a, b, c) -> a + b + c); //결합
				source.subscribe(Log::i); //구독하여 Log.i의 형태로 출력
		CommonUtils.exampleComplete();
	}
	
	//시간 결합, zipInterval기법. 시간을 결합하면 발행시간을 조절할 수 있음
	public void zipInterval() {
		String[] colors = {"RED", "GREEN", "BLUE"};
		Observable<String> source = Observable.zip(
				Observable.fromArray(colors),
				Observable.interval(200L, TimeUnit.MILLISECONDS),
				(value, i) -> value); //결합함수를 (value, i) -> value로 선언하여 값이 value만 나오게 함
		
		CommonUtils.exampleStart(); //시간측정
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	//zipWith, zip과 동일하나 zip과 달리 조합하면서 호출가능
	public void zipWithNumbers() {
		Observable<Integer> source = Observable.zip(
			Observable.just(100, 200, 300),
			Observable.just(10, 20, 30), 
			(a, b) -> a + b)
			.zipWith(Observable.just(1, 2, 3), (ab, c) -> ab + c);
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	
	public static void main(String[] args) {
		ZipExample demo = new ZipExample();
		
		demo.marbleDiagram();
		demo.zipNumbers();
		demo.zipInterval();
		demo.zipWithNumbers();
	}

}
