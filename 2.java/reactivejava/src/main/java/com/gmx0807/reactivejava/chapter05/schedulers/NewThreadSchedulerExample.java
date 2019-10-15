package com.gmx0807.reactivejava.chapter05.schedulers;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.BLUE;

public class NewThreadSchedulerExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] orgs = { RED, GREEN, BLUE };
		
		/*
		 * 동작순서 Thread1 -> CommonUtils -> Thread2 
		 * 추천하는 방법은 아님
		 */

		
		//#RxRxNewThreadScheduler-1 
		Observable.fromArray(orgs).doOnNext(data -> Log.v("Original data: " + data)).map(data -> "<<" + data + ">>")
				.subscribeOn(Schedulers.newThread()).subscribe(Log::i);
		CommonUtils.sleep(500);

		//#RxNewThreadScheduler-1 
		Observable.fromArray(orgs).doOnNext(data -> Log.v("Original data: " + data)).map(data -> "##" + data + "##")
				.subscribeOn(Schedulers.newThread()).subscribe(Log::i);
		CommonUtils.sleep(500);
		

		CommonUtils.exampleComplete();
	}

	public static void main(String[] args) {
		NewThreadSchedulerExample demo = new NewThreadSchedulerExample();
		demo.marbleDiagram();
	}

}
