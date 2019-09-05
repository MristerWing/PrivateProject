package com.gmx0807.reactivejava.chapter05.schedulers;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import com.gmx0807.reactivejava.common.*;

/*
 * 네크워크 상의 요청을 처리하거나 
 * 각종 입,출력 작업을 실행하기 위한 스케줄러
 * 계산 스케줄러는 CPU의 갯수만큼 thread를 생성하지만
 * IO스케줄러는 필요할 때 마다 thread를 생성한다.
 * IO작업은 비동기로 실행되지만 결과를 얻기까지 대기시간이 길다.
*/

public class IOSchedulerExample {

	public void basic() {
		//list up filees on C drive root
		String root = "c:\\";
		File[] files = new File(root).listFiles();					//해당경로의 File객체를 생성하여 listFile() method를 호출하면 파일목록을 File[]배열로 리턴
		Observable<String> source = Observable.fromArray(files)		
				.filter(f -> !f.isDirectory())						//Directory를 제외한 File만 필터링
				.map(f -> f.getAbsolutePath())						//File[]배열에 있는 File의 절대경로를 발행
				.subscribeOn(Schedulers.io());						//IO스케줄러에서 실행
		
		source.subscribe(Log::i);
		CommonUtils.sleep(500);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		IOSchedulerExample demo = new IOSchedulerExample();
		demo.basic();
	}

}
