package com.gmx0807.reactivejava.chapter03;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.Scanner;

public class Gugudan {
	public void reactiveV1() {
		Scanner in = new Scanner(System.in);
		System.out.println("Guguda Input: ");
		int dan = Integer.parseInt(in.nextLine());

		Observable<Integer> source = Observable.range(1, 9);
		source.subscribe(row -> System.out.println(dan + " X " + row + " = " + (dan * row)));
		in.close();
	}

	public void reactiveV2() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input: ");
		int dan = Integer.parseInt(in.nextLine());

		//gugudan  함수를 생성하여 입력값을 확인
		Function<Integer, Observable<String>> gugudan = num -> // num is variable
		Observable.range(1, 9).map(row -> num + " X " + row + " = " + (dan * row));
		//function
		
		/*
		 * 어떠한 문제가 발생하면 그 문제에 맞는 함수를 집어 넣는다. 
		 * 메소드?
		 * 
		 */
		
		Observable<String> source = Observable.just(dan).flatMap(gugudan);
		source.subscribe(System.out::println);
		in.close();
	}
	
	public void reactiveV3() {
		Scanner in = new Scanner(System.in);
		System.out.println("Guguda Input: ");
		int dan = Integer.parseInt(in.nextLine());
		
//		인자는 just()-> flatMap() -> map()순으로 전달되며 num이 dan의 값을 전달받는다.
		Observable<String> source = Observable.just(dan)
				.flatMap(num -> Observable.range(1,9)
				.map(row -> num + " X " + row + " = " + (dan * row)));
		
		source.subscribe(System.out::println);
		in.close();
	}
	
	public void usingResultSeletor() {
		Scanner in = new Scanner(System.in);
		System.out.println("Guguda Input: ");
		int dan = Integer.parseInt(in.nextLine());
		
		/*
		 * resultSelector를 사용한 방식이다. 
		 * Observable.just(dan)에서 발행하는 값이 flatMap의 gugu로 전달되며,
		 * 이후 Observable.range()함수가 BiFunction(T, U, R)의 U를 의미하게 된다. 
		 * 최종 반환값은 range의 반환값이 된다.
		 */
		
		Observable<String> source = Observable.just(dan)
				.flatMap(gugu -> Observable.range(1, 9),
						(gugu, i) -> gugu + " + " + i + " = " + (gugu * i)); //resultSelector
		
		source.subscribe(System.out::println);
		in.close();
	}
	
	public void doubleRangeGugu() {

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gugudan gu = new Gugudan();

//		gu.reactiveV3();
		gu.usingResultSeletor();
	}

}
