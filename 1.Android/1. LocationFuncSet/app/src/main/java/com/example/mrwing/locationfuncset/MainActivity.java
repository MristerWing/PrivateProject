package com.example.mrwing.locationfuncset;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {
    public static final String PREFS_NAME = "setup";
    private LocationManager locManager;
    private LocationListener locationListener;
    private LocationManager pLocManager;
    private LocationListener pLocationListener;
    private boolean opertain;
    private double latitude; //위도
    private double longitude; //경도
    private double altitude; //고도
    private GoogleMap gmap;
    private SupportMapFragment mapFrag;
    private Handler mHandler;
    private static final int LOCATION_UPDATE = 1;
    SetupInfo receiver;
    PendingIntent proximityIntent;

    private static int iWCheck;
    private static int iSCheck;
    private static int oWCheck;
    private static int oSCheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_main);

        ToggleButton toggleOpertaionCheck = (ToggleButton) findViewById(R.id.operation_toggle);
        final TextView textLocationInfo = (TextView) findViewById(R.id.locationinfo);
        Button btnLocationMain = (Button) findViewById(R.id.mainloaction);
        Button btnLocationSet = (Button) findViewById(R.id.locationset);
        toggleOpertaionCheck.setOnClickListener((View.OnClickListener) this);
        textLocationInfo.setOnClickListener((View.OnClickListener) this);
        btnLocationMain.setOnClickListener((View.OnClickListener) this);
        btnLocationSet.setOnClickListener((View.OnClickListener) this);
        mapFrag = (SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.mapView);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        opertain = settings.getBoolean("opCheck", true);
        latitude = Double.longBitsToDouble(settings.getLong("lat", 0));
        longitude = Double.longBitsToDouble(settings.getLong("lon", 0));
        altitude = Double.longBitsToDouble(settings.getLong("alt", 0));

        Intent intent = getIntent();
        if(intent.getStringExtra("IWC") != null) {
            iWCheck = Integer.parseInt(intent.getStringExtra("IWC"));
            iSCheck = Integer.parseInt(intent.getStringExtra("ISC"));
            oWCheck = Integer.parseInt(intent.getStringExtra("OWC"));
            oSCheck = Integer.parseInt(intent.getStringExtra("OSC"));
        }
        else {
            iWCheck = settings.getInt("IWC", -1);
            iSCheck = settings.getInt("ISC", -1);
            oWCheck = settings.getInt("OWC", -1);
            oSCheck = settings.getInt("OSC", -1);
        }

        toggleOpertaionCheck.setChecked(opertain);
        mapFrag.getMapAsync(this);


        textLocationInfo.setText("기준장소: " + "\n" + getAddress(latitude, longitude));

        if (opertain) {
            textLocationInfo.setEnabled(true);
            btnLocationMain.setEnabled(true);
            btnLocationSet.setEnabled(true);
            setProximityAlert();
        } else {
            textLocationInfo.setEnabled(false);
            btnLocationMain.setEnabled(false);
            btnLocationSet.setEnabled(false);
        }
    }

    public void onClick(View view) {
        final TextView locationInfo = (TextView) findViewById(R.id.locationinfo);
        Button locationMain = (Button) findViewById(R.id.mainloaction);
        Button locationSet = (Button) findViewById(R.id.locationset);

        switch (view.getId()) {
            case R.id.operation_toggle:
                boolean on = ((ToggleButton) view).isChecked();

                if (on) {
                    locationInfo.setEnabled(true);
                    locationMain.setEnabled(true);
                    locationSet.setEnabled(true);
                    locationSetup(locationInfo);
                    setProximityAlert();
                    opertain = true;
                } else {
                    locationInfo.setEnabled(false);
                    locationMain.setEnabled(false);
                    locationSet.setEnabled(false);
                    if(locManager != null) {
                        locManager.removeUpdates(locationListener);
                        locManager = null;
                    }
                    if(pLocManager != null) {
                        pLocManager.removeProximityAlert(proximityIntent);
                        pLocManager.removeUpdates(pLocationListener);
                        pLocManager = null;
                    }
                    opertain = false;
                }
                break;
            case R.id.mainloaction:
                if (locManager == null)
                    locationSetup(locationInfo);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                //gpsChecker[0] = true;
                break;
            case R.id.locationset:
                Intent inent4set = new Intent(this, SettingActivity.class);
                inent4set.putExtra("IWC", String.valueOf(iWCheck));
                inent4set.putExtra("ISC", String.valueOf(iSCheck));
                inent4set.putExtra("OWC", String.valueOf(oWCheck));
                inent4set.putExtra("OSC", String.valueOf(oSCheck));
                startActivity(inent4set);
                break;
        }
    }

    public void locationSetup(final TextView text) {
        locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        mHandler = new Handler(new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case LOCATION_UPDATE:
                        stopLocationUpdates();
                        return true;
                    default:
                        return false;
                }
            }
        });

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                altitude = location.getAltitude();
                gmap.clear();
                gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 18));
                onAddMarker();
                text.setText("기준장소: " + "\n" + getAddress(latitude, longitude));
                stopLocationUpdates();
            }

            @Override
            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProviderEnabled(String provider) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub
            }
        };
    }

    public void stopLocationUpdates() {
        if (locManager != null) {
            locManager.removeUpdates(locationListener);
            locManager = null;
            mHandler.removeMessages(LOCATION_UPDATE);
        }
    }


    public String getAddress(double lat, double lng) {
        String nowAddress = "현재 위치를 확인 할 수 없습니다.";
        Geocoder geocoder = new Geocoder(this, Locale.KOREA);
        List<Address> address;
        try {
            if (geocoder != null) {
                //세번째 파라미터는 좌표에 대해 주소를 리턴 받는 갯수로
                //한좌표에 대해 두개이상의 이름이 존재할수있기에 주소배열을 리턴받기 위해 최대갯수 설정
                address = geocoder.getFromLocation(lat, lng, 1);

                if (address != null && address.size() > 0) {
                    // 주소 받아오기
                    String currentLocationAddress = address.get(0).getAddressLine(0).toString();
                    nowAddress = currentLocationAddress;

                }
            }

        } catch (IOException e) {
            nowAddress = "주소를 가져 올 수 없습니다.";
            e.printStackTrace();
        }
        return nowAddress;
    }

    public void setProximityAlert() {
        receiver = new SetupInfo();
        proximityLocation();

        // ProximityAlert 등록
        Intent intent = new Intent("com.example.mrwing.locationfuncset");
        proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        pLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, pLocationListener);
        pLocManager.addProximityAlert(latitude, longitude, 5, -1, proximityIntent);
        IntentFilter filter = new IntentFilter("com.example.mrwing.locationfuncset");
        registerReceiver(receiver, filter);
    }

    public void proximityLocation() {
        pLocManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        pLocationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProviderEnabled(String provider) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub
            }
        };
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("opCheck", opertain);
        this.putDouble(editor,"lat", latitude);
        this.putDouble(editor,"lon", longitude);
        this.putDouble(editor, "alt", altitude);
        editor.putInt("IWC", iWCheck);
        editor.putInt("ISC", iSCheck);
        editor.putInt("OWC", oWCheck);
        editor.putInt("OSC", oSCheck);
        editor.commit();
        if(locManager != null) {
            locManager.removeUpdates(locationListener);
            locManager = null;
        }
        if(!opertain) {
            if (pLocManager != null) {
                pLocManager.removeProximityAlert(proximityIntent);
                pLocManager.removeUpdates(pLocationListener);
                pLocManager = null;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    SharedPreferences.Editor putDouble(final SharedPreferences.Editor edit, final String key, final double value) {
        return edit.putLong(key, Double.doubleToRawLongBits(value));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 18));
        onAddMarker();
    }

    public void onAddMarker(){
        LatLng position = new LatLng(latitude , longitude);

        //나의위치 마커
        MarkerOptions myMarker = new MarkerOptions().position(position);   //마커위치

        CircleOptions circle = new CircleOptions().center(position) //원점
                .radius(30)      //반지름 단위 : m
                .strokeWidth(0f)  //선너비 0f : 선없음
                .fillColor(Color.parseColor("#880000ff")); //배경색

        //마커추가
        this.gmap.addMarker(myMarker);

        //원추가
        this.gmap.addCircle(circle);
    }

    public static int getiWCheck() {
        return iWCheck;
    }

    public static int getoWCheck() {
        return oWCheck;
    }

    public static int getiSCheck() {
        return iSCheck;
    }

    public static int getoSCheck() {
        return oSCheck;
    }
}
