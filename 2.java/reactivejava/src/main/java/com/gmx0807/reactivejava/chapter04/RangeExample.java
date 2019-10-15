package com.gmx0807.reactivejava.chapter04;

import com.gmx0807.reactivejava.common.*;
import io.reactivex.Observable;

/*range�� for�� ��ü, filter�� if���� ��ü*/


public class RangeExample {

	public void forLoop() {
		/*
		 * 1 ~10������ ���� �����Ͽ� �����鼭 ������ �����Լ��� 
		 * �����ϸ� �� ���� ���Ѵ�.
		 * ���� �����忡�� �����ϱ� ������ sleep�� ȣ������ �ʴ´�.
		 */
		
		Observable<Integer> source = Observable.range(1, 10) //for
				.filter(number -> number % 2 == 0);			 //if
		
		source.subscribe(Log::it);
	}
	
	public static void main(String[] args) {
		RangeExample demo = new RangeExample();
		demo.forLoop();

	}

}
