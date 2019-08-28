package com.gmx0807.reactivejava.chapter04;
import io.reactivex.*;
import io.reactivex.Observable;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.*;;

public class TimerExample {

	public void showTime() {
		CommonUtils.exampleStart();
		Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS) //500ms뒤에 실행
				.map(notUsed -> {
					return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
							.format(new Date());
				});
		source.subscribe(Log::it);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		TimerExample demo = new TimerExample();
		
		demo.showTime();

	}

}
