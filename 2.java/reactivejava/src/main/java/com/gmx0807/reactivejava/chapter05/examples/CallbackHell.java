package com.gmx0807.reactivejava.chapter05.examples;

import java.io.IOException;

import com.gmx0807.reactivejava.common.Log;
import static com.gmx0807.reactivejava.common.CommonUtils.GITHUB_ROOT;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CallbackHell {
	private static final String FIRST_URL = "https://api.github.com/zen";
	private static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_hell";

	private final OkHttpClient client = new OkHttpClient();
	
	private Callback onSuccess = new Callback () {
		@Override
		public void onFailure(Call call, IOException e) {
			e.printStackTrace();
		}
		
		@Override
		public void onResponse(Call call, Response response) throws IOException {
			Log.i(response.body().string());
		}
	};
	
	public void run() {

		//첫번째 GET
		Request request = new Request.Builder()
				.url(FIRST_URL)
				.build();
		
		/*
		 * 이렇게 생성됭 이유는 지역변수를 사용할 수 없기 때문에 
		 * 객체의 맴버 변수로 선언해야 되기 때문임
		 * 즉, 첫번째 GET의 호출의 성공과 실패가 있고
		 * 두번째 GET의 성공과 실패를 전부 고려해서 코드를 짜야 하므로 이런식의 결과가 나온것.
		 */
		
		//두번째 GET
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				Log.i(response.body().string());
				
				//add callback again
				Request request = new Request.Builder()
						.url(SECOND_URL)
						.build();
				
				client.newCall(request).enqueue(onSuccess);
			}
		});
	}

	public static void main(String[] args) {
		CallbackHell demo = new CallbackHell();
		demo.run();
	}

}
