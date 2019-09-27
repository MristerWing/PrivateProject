package com.gmx0807.reactivejava.chapter03.dataQuery;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.gmx0807.reactivejava.common.CommonUtils;

import io.reactivex.Maybe;
import io.reactivex.Observable;

/* 함수형 프로그래밍에서는 자료구조 클래스를 
 * 새로 생성하기 보단 Pair혹은 Tuple같은 일반화 된 자료구조를 선호한다.
 * 이유는 기존에 만들어진 함수를 활용하는 폭이 넓어지기 때문이다.
 * 함수형 프로그래밍이라고 할지여도 자료구조는 필요하다.*/

public class QueryTvSales {
	public void run() {
		
		//Pair타입의 클래스를 저장하는 sales ArrayList를 생성
		// 1. 데이터 입력
		List<Pair<String, Integer>> sales = new ArrayList<>();
		
		//Pair.of(): 정적 팩토리 함수, List객체에 추가함
		sales.add(Pair.of("TV", 2500));
		sales.add(Pair.of("Camera", 300));
		sales.add(Pair.of("TV", 1600));
		sales.add(Pair.of("Phone", 800));

		//reduce함수는 결과값이 반환이 안될수도 있기때문에 Observable이 아닌 Maybe를 선언함
		Maybe<Integer> tvSales = Observable.fromIterable(sales)
				// 2. 매출 데이터중 TV 매출을 필터링 함, 이때 TV는 왼쪽에 있기 때문에 왼쪽의 값만 flitering을 함
				.filter(sale -> "TV".equals(sale.getLeft())).map(sale -> sale.getRight())
				// 3. TV 매출의 합을 구함, reduce()의 인자는 2개이기 때문에 괄호로 묶어줘야 함
				.reduce((sale1, sale2) -> sale1 + sale2);
		
		//subscribe()를 호출하여 실제 함수를 시작
		tvSales.subscribe(tot -> System.out.println("TV Sales: $" + tot));
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		QueryTvSales demo = new QueryTvSales();
		demo.run();
	}
}
