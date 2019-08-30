package com.gmx0807.reactivejava.chapter04.combine;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.text.DecimalFormat;

import org.apache.commons.lang3.tuple.Pair;

import com.gmx0807.reactivejava.common.Log;

import io.reactivex.Observable;

public class ElectricBills {

	public void electricBill() {
		String[] data = { "100", // 910 + 93.3 * 100 = 10,240원
				"300", // 1600 + 93.3 * 200 + 187.9 * 100 = 39,050원
				"800", // 7300 + 93.3 * 200 + 187.9 * 200 + 280.65 * 200 = 175,800원
		};

		// 기본요금
		Observable<Integer> basePrice = Observable.fromArray(data).map(Integer::parseInt).map(val -> {
			if (val <= 200)
				return 910;
			if (val <= 400)
				return 1600;
			return 7300;
		});

		// 사용한 요금 min: Math.min max: Math.max
		Observable<Integer> usagePrice = Observable.fromArray(data).map(Integer::parseInt).map(val -> {
			double series1 = min(200, val) * 93.3;
			double series2 = min(200, max(val - 200, 0)) * 187.9;
			double series3 = max(0, max(val - 400, 0)) * 280.65;
			return (int) (series1 + series2 + series3);
		});
		Observable<Pair<String, Integer>> source = Observable.zip(basePrice, usagePrice, Observable.fromArray(data),
				(v1, v2, i) -> Pair.of(i, v1 + v2));

//		결과출력 val = Left: 사용한 kWh Right: 기본요금 + 사용한요금
//		source의 값을 map 함수를 이용하여 변환한다.
//		아래와 같이 작성된 이유는 SideEffct를 없에기 위함이다.
		source.map(val -> Pair.of(val.getLeft(), // return값중 left의 값 사용한kWh

//		DecimalFormat: 특정 패턴으로 format하는 클래스, 반환값 String.
//		패턴의 지정은 0과 #으로지정한다.(Ex:"0.###" or "000.###)
//		"0"은 해당 자리수의 값이 최소한으로 있어야 한다
//		"#"은 최대한 해당 소수점 자리수 까지 반올림한다.
//		Ex: 78.53981633의 경우
//		0.###: 78.54(0은 미출력)
//		000.##: 078.54
//		00.#: 78.5

				new DecimalFormat("#,###").format(val.getValue()))).subscribe(val -> {
//		StringBuilder: String클래스가 새로 생성되면 메모리상에 그 값이 계속해서 쌓인다
//		이를 방지하기위해 메모리에 생성하는게 아닌 기존에 메모리상에 더 하는
//		StringBuilder나 StringBuffer를 사용하여 해결한다.
//		이때 둘의 차이는 Buffer는 단일 Thread환경에서만 동작하며
//		Builder는 멀티스레드 환경에서 멀티스레드를 이용하여 동작하는 차이가있다.
					StringBuilder sb = new StringBuilder();
					sb.append("Usage: " + val.getLeft() + "kWh => ");
					sb.append("Price: " + val.getRight() + "원");
					Log.i(sb.toString());

				});
	}

	public static void main(String[] args) {
		ElectricBills demo = new ElectricBills();
		demo.electricBill();
	}

}
