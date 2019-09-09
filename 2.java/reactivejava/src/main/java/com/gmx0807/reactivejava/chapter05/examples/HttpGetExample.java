package com.gmx0807.reactivejava.chapter05.examples;

import java.io.IOException;

import com.gmx0807.reactivejava.common.CommonUtils;
import com.gmx0807.reactivejava.common.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpGetExample {
	
	private final OkHttpClient client = new OkHttpClient();
	
	private static final String URL_RENAME = "https://raw.githubusercontent.com/yudong80/reactivejava/master/README.md";
	
	public void run() {
		
		//GET을 이용하여 http URL을 얻어온다.
		Request request = new Request.Builder()
				.url(URL_RENAME)
				.build();
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Log.i(response.body().string());
			}
		});
		CommonUtils.exampleComplete();
		
	}

	public static void main(String[] args) {
		HttpGetExample demo = new HttpGetExample();
		demo.run();
	}

}
