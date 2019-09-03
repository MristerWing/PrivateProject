package com.gmx0807.reactivejava.chapter04.combine;

import java.util.concurrent.TimeUnit;

import com.gmx0807.reactivejava.common.*;

import io.reactivex.Observable;

import static com.gmx0807.reactivejava.common.Shape.YELLOW;
import static com.gmx0807.reactivejava.common.Shape.RED;
import static com.gmx0807.reactivejava.common.Shape.GREEN;
import static com.gmx0807.reactivejava.common.Shape.SKY;
import static com.gmx0807.reactivejava.common.Shape.PUPPLE;

/*merge는 순서와 모든 Observable이 데이터를 발행하는지 등에 
*관여하지 않고 어느것이든 업스티림에서 먼저 입력되는 값을 그대로 발행한다.
*첫번째 Observable과 두번째 Observable의 데이터 발행은 각자의 스레드에서 발행된다.
*/

public class MergeExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] data1 = {RED, GREEN}; //1, 3
		String[] data2 = {YELLOW, SKY, PUPPLE}; //2, 4, 6
		
		Observable<String> source1 = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> data1[idx])
				.take(data1.length);
		
		Observable<String> source2 = Observable.interval(50L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(idx -> data2[idx])
				.take(data2.length);
		
		Observable<String> source = Observable.merge(source1, source2);
		source.subscribe(Log::i);
		
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
		
	}
	
	public static void main(String[] args) {
		MergeExample demo = new MergeExample();
		demo.marbleDiagram();

	}

}
