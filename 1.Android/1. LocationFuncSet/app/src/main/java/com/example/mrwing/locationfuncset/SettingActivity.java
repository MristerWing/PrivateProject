package com.example.mrwing.locationfuncset;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingActivity extends Activity implements View.OnClickListener {
    private int iWCheck;
    private int iSCheck;
    private int oWCheck;
    private int oSCheck;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_setting);

        Button btnInWifi = findViewById(R.id.in_wifi);
        Button btnInSound = findViewById(R.id.in_sound);
        Button btnOutWifi = findViewById(R.id.out_wifi);
        Button btnOutSound = findViewById(R.id.out_sound);

        btnInWifi.setOnClickListener((View.OnClickListener) this);
        btnInSound.setOnClickListener((View.OnClickListener) this);
        btnOutWifi.setOnClickListener((View.OnClickListener) this);
        btnOutSound.setOnClickListener((View.OnClickListener) this);

        Intent intent = getIntent();
        iWCheck = Integer.parseInt(intent.getStringExtra("IWC"));
        iSCheck = Integer.parseInt(intent.getStringExtra("ISC"));
        oWCheck = Integer.parseInt(intent.getStringExtra("OWC"));
        oSCheck = Integer.parseInt(intent.getStringExtra("OSC"));

    }

    @Override
    public void onClick(View view) {
        String i;
        final Button btnInWifi = findViewById(R.id.in_wifi);
        Button btnInSound = findViewById(R.id.in_sound);
        Button btnOutWifi = findViewById(R.id.out_wifi);
        Button btnOutSound = findViewById(R.id.out_sound);

        switch (view.getId()) {
            case R.id.in_wifi:
                final CharSequence[] iwitems = {"켜짐", "꺼짐"};
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("WIFI 켜짐 여부");
                builder.setSingleChoiceItems(iwitems, iWCheck, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), String.valueOf(which), Toast.LENGTH_SHORT).show();
                        iWCheck = which;
                    }
                });
                builder.setPositiveButton("닫기", null);
                builder.show();
                break;
            case R.id.in_sound:
                final CharSequence[] isitems = {"소리", "진동", "무음"};
                AlertDialog.Builder isbuilder = new AlertDialog.Builder(this);
                isbuilder.setTitle("소리 모드 여부");
                isbuilder.setSingleChoiceItems(isitems, iSCheck, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), isitems[which], Toast.LENGTH_SHORT).show();
                        iSCheck = which;
                    }
                });
                isbuilder.setPositiveButton("닫기", null);
                isbuilder.show();
                break;
            case R.id.out_wifi:
                final CharSequence[] owitems = {"켜짐", "꺼짐"};
                AlertDialog.Builder owbuilder = new AlertDialog.Builder(this);
                owbuilder.setTitle("WIFI 켜짐 여부");
                owbuilder.setSingleChoiceItems(owitems, oWCheck, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), owitems[which], Toast.LENGTH_SHORT).show();
                        oWCheck = which;
                    }
                });
                owbuilder.setPositiveButton("닫기", null);
                owbuilder.show();
                break;
            case R.id.out_sound:
                final CharSequence[] ositems = {"소리", "진동", "무음"};
                AlertDialog.Builder osbuilder = new AlertDialog.Builder(this);
                osbuilder.setTitle("소리 모드 여부");
                osbuilder.setSingleChoiceItems(ositems, oSCheck, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), ositems[which], Toast.LENGTH_SHORT).show();
                        oSCheck = which;
                    }
                });
                osbuilder.setPositiveButton("닫기", null);
                osbuilder.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent inent4set = new Intent(this, MainActivity.class);
        inent4set.putExtra("IWC", String.valueOf(iWCheck));
        inent4set.putExtra("ISC", String.valueOf(iSCheck));
        inent4set.putExtra("OWC", String.valueOf(oWCheck));
        inent4set.putExtra("OSC", String.valueOf(oSCheck));
        startActivity(inent4set);
    }

    protected void onStop() {
        super.onStop();
        Intent inent4set = new Intent(this, MainActivity.class);
        inent4set.putExtra("IWC", String.valueOf(iWCheck));
        inent4set.putExtra("ISC", String.valueOf(iSCheck));
        inent4set.putExtra("OWC", String.valueOf(oWCheck));
        inent4set.putExtra("OSC", String.valueOf(oSCheck));
    }
}
