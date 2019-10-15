package com.gmx0807.reactivejava.chapter04.conditional;

import io.reactivex.Observable;
import io.reactivex.Single;

import com.gmx0807.reactivejava.common.*;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.GREEN;


public class AllExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] data = {RED, YELLOW, GREEN, SKY};
		
		Single<Boolean> source = Observable.fromArray(data)
				.map(Shape::getShape)
				.all(Shape.BALL::equals);
//				.all(val -> Shape.BALL.equals(Shape.getShape(val)));
		
		source.subscribe(bool -> Log.i(bool));
//		source.subscribe(Log::i); 는 컴파일러가 모호하다고 해서 컴파일 불가능
		
	}
	
	public static void main(String[] args) {
		AllExample demo = new AllExample();
		demo.marbleDiagram();

	}

}
