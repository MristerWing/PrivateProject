package com.gmx0807.reactivejava.chapter05.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gmx0807.reactivejava.common.CommonUtils;
import com.gmx0807.reactivejava.common.Log;
import com.gmx0807.reactivejava.common.OkHttpHelper;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.gmx0807.reactivejava.common.CommonUtils.API_KEY;

public class OpenWeatherMapV1 {
	private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=";

	public void run() {
		Observable<String> source = Observable.just(URL + API_KEY).map(OkHttpHelper::getWithLog)	//원본 json
				.subscribeOn(Schedulers.io());

		// 어떻게 해야 한번에 호출 할 수 있을까?, 핵심 Logic
		Observable<String> temperature = source.map(this::parseTemperature);
		Observable<String> city = source.map(this::parseCityName);
		Observable<String> country = source.map(this::parseCountry);

		CommonUtils.exampleStart();
		Observable.concat(temperature, city, country).observeOn(Schedulers.newThread()).subscribe(Log::it);

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
		OpenWeatherMapV1 demo = new OpenWeatherMapV1();
		demo.run();
	}
}
