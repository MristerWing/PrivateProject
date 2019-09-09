package com.gmx0807.reactivejava.chapter05.examples;

import static com.gmx0807.reactivejava.common.CommonUtils.API_KEY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gmx0807.reactivejava.common.CommonUtils;
import com.gmx0807.reactivejava.common.Log;
import com.gmx0807.reactivejava.common.OkHttpHelper;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

//connectableObservable 클래스 사용
public class OpenWeatherMapV2 {
	private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=";
	
	public void run() {
		CommonUtils.exampleStart();
		
		//connectableObservable의 차가운 Observable을 뜨거운 Observable로 변환하여 여러 구독자가 구독하는 방식으로 해결
		Observable<String> source = Observable.just(URL + API_KEY)
				.map(OkHttpHelper::getWithLog)
				.subscribeOn(Schedulers.io())
				/* connectableObservable class의 publish()와 refCount()함수를 사용 
				 * 이 두 함수를 합치면 Observable의 share()함수가 됨*/
				.share()
				.observeOn(Schedulers.newThread());
		
		/* 여러 구독자가 하나의 connectable함수를 구독 
		 * subscribe()함수를 호출하면 Observable의 데이터가 다시 발행되기 
		 * 때문에 서버의 REST API를 다시 호출할 필요가 없음*/
		source.map(this::parseTemperature).subscribe(Log::it);
		source.map(this::parseCityName).subscribe(Log::it);
		source.map(this::parseCountry).subscribe(Log::it);

		CommonUtils.sleep(3000);

	}

	private String parseTemperature(String json) {
		return parse(json, "\"temp\":[0-9]*.[0-9]*");
	}

	private String parseCityName(String json) {
		return parse(json, "\"name\":\"[a-zA-Z]*\"");
	}

	private String parseCountry(String json) {
		return parse(json, "\"country\":\"[a-zA-Z]*\"");
	}

	private String parse(String json, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(json);
		if (match.find()) {
			return match.group();
		}
		return "N/A";
	}

	public static void main(String[] args) {
		OpenWeatherMapV2 demo = new OpenWeatherMapV2();
		demo.run();

	}

}
