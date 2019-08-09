package com.gmx0807.reactivejava.chapter02;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class ObservableCeateExample {
	
	public void emit() {
		Observable<Integer> source = Observable.create(
				(ObservableEmitter<Integer> emitter) -> {
					emitter.onNext(100);
					emitter.onNext(200);
					emitter.onNext(300);
					emitter.onComplete();
				});
		
		//data�� ������ �̸��̹Ƿ� ���ϴ� ���������� ����
		
		/* �͸�ü
		 * source.subscribe(new Consumer<Integer>() {
		 * 
		 * @Override public void accept(Integer data) throws Exception {
		 * System.out.printIn("Result : " + data); } });
		 */
		
		//���ٽ�
		//source.subscribe(data -> System.out.println("Result : " + data)); 
		
		//System.out::println ���� ���¸� �޼��� ���۷��������
		source.subscribe(System.out::println);
	}

	public static void main(String[] args) {
		ObservableCeateExample demo = new ObservableCeateExample();
		demo.emit();

	}

}
