package com.example.mrwing.locationfuncset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import static android.content.Context.WIFI_SERVICE;

public class SetupInfo extends BroadcastReceiver {
    ConnectivityManager manager;
    private int inWifi = MainActivity.getiWCheck();
    private int inSound = MainActivity.getiSCheck();
    private int outWifi = MainActivity.getoWCheck();
    private int outSound = MainActivity.getoSCheck();

        @Override
        public void onReceive(Context context, Intent intent) {
            String key = LocationManager.KEY_PROXIMITY_ENTERING;
            Boolean isEntering = intent.getBooleanExtra(key, false);
            AudioManager aManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE); //진동모드확인
            WifiManager wifiManager=(WifiManager)context.getSystemService(WIFI_SERVICE); //활성화 한지 와이파이 체크 하기 위함
            manager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE); //와이파이 연결 체크
            NetworkInfo wifi = manager.getActiveNetworkInfo();//와이파이 연결 체크 // wifi 또는 모바일 네트워크 어느 하나라도 연결이 되어있다면,
            if(isEntering == true) {
                Toast.makeText(context, "장소에 도착하였습니다.", Toast.LENGTH_SHORT).show();
                switch (inWifi) {
                    case 0:
                        if (wifi.isConnected()) {
                            if (wifi.getTypeName() == "WIFI") {
                                Toast.makeText(context.getApplicationContext(), "WIFI 연결되어있음", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context.getApplicationContext(), "WIFI를 연결합니다.", Toast.LENGTH_SHORT).show();
                                /////////활성화 되지 않았다면 활성화 코드 추가
                                wifiManager.setWifiEnabled(true); //와이파이 활성화
                            }
                        } else {
                            Toast.makeText(context.getApplicationContext(), "WIFI를 연결합니다.", Toast.LENGTH_SHORT).show();
                            wifiManager.setWifiEnabled(true);
                        }
                        break;
                    case 1:
                        Toast.makeText(context.getApplicationContext(), "WIFI를 해제합니다.", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(false);
                        break;
                }

                switch (inSound) {
                    case 0:
                        Toast.makeText(context.getApplicationContext(), "소리모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                        aManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        break;
                    case 1:
                        aManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        Toast.makeText(context.getApplicationContext(), "진동모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context.getApplicationContext(), "무음모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                        aManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        break;
                }
            }
            else  {
                Toast.makeText(context, "장소에서 이탈합니다.", Toast.LENGTH_SHORT).show();
                switch (outSound) {
                    case 0:
                        if (wifi.isConnected()) {
                            if (wifi.getTypeName() == "WIFI") {
                                Toast.makeText(context.getApplicationContext(), "WIFI 연결됨", Toast.LENGTH_SHORT).show();
                                //Log.i("연결됨", "와이파이 연결되어있음"); //와이파이 연결 되있을 때 구분 구문
                            } else {
                                Toast.makeText(context.getApplicationContext(), "WIFI를 연결합니다.", Toast.LENGTH_SHORT).show();

                                /////////활성화 되지 않았다면 활성화 코드 추가
                                wifiManager.setWifiEnabled(true); //와이파이 활성화
                            }
                        }
                        break;
                    case 1:
                        Toast.makeText(context.getApplicationContext(), "WIFI를 해제합니다.", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(false);
                        break;
                }

                switch (outSound) {
                    case 0:
                        Toast.makeText(context.getApplicationContext(), "소리모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                        aManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        break;
                    case 1:
                        Toast.makeText(context.getApplicationContext(), "진동모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                        aManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        break;
                    case 2:
                        Toast.makeText(context.getApplicationContext(), "무음모드로 전환합니다.", Toast.LENGTH_SHORT).show();
                        aManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        break;
                }
            }
        }

}
