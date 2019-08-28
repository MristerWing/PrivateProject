package com.gmx0807.reactivejava.chapter04;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import com.gmx0807.reactivejava.common.*;

/*������������ �������� �帧�� �����ϴ� �Լ�
 * �־��� �ð����κ��� 0���� 1�� �����ϴ� Long ��ü�� ����
 * range = for
 * interval = ������ �����̸� �ִ� for*/

public class IntervalExample {
	
	/*
	 * 100ms�������� 0���� �����͸� ������ �� map()�Լ��� ȣ���Ͽ� 
	 * �Է°���1�� ���� �� 100�� ���ϴ� �Լ�
	 */
	public void printNumbers() {
		CommonUtils.exampleComplete();
		Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(data -> (data + 1) * 100)
				.take(5);
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	
//	����������
	public void noInitialDelay() {
		CommonUtils.exampleComplete();
		Observable<Long> source = Observable.interval(0L, 100L, TimeUnit.MICROSECONDS)
				.map(val -> val + 100)
				.take(5);
		
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		IntervalExample demo = new IntervalExample();
		demo.printNumbers();
//		demo.noInitialDelay();

	}

}
