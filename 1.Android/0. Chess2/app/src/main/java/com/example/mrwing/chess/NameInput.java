package com.example.mrwing.chess;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameInput extends Activity implements View.OnClickListener{
    private String p1Set;
    private String p2Set;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_name);
        Button boardButton = (Button) findViewById(R.id.complete);
        final EditText player1 = findViewById(R.id.player1_text);
        final EditText player2 = findViewById(R.id.player2_text);

        Intent intet = getIntent();
        p1Set = intet.getExtras().getString("P1AI");
        p2Set = intet.getExtras().getString("P2AI");

        Log.i(this.getClass().getName(), p1Set);
        Log.i(this.getClass().getName(), p2Set);

        if(p1Set.equals("AI")) {
            player1.setText("A.I");
            player1.setClickable(false);
            player1.setEnabled(false);
            player1.setFocusable(false);
            player1.setFocusableInTouchMode(false);
        }

        if(p2Set.equals("AI")) {
            player2.setText("A.I");
            player2.setClickable(false);
            player2.setEnabled(false);
            player2.setFocusable(false);
            player2.setFocusableInTouchMode(false);
        }

        boardButton.setOnClickListener(this);
        //player1.set
    }

    @Override
    public void onClick(View view) {
        final EditText player1 = findViewById(R.id.player1_text);
        final EditText player2 = findViewById(R.id.player2_text);
        String player1_name = "";
        String player2_name = "";
        switch (view.getId()) {
            case R.id.complete:
                player1_name = player1.getText().toString();
                player2_name = player2.getText().toString();
                //A,I아닌데 이름이 A.I면 거름
                if ((!p1Set.equals("AI") && player1_name.equals("A.I")) || (!p2Set.equals("AI") && player2_name.equals("A.I"))) {
                    Toast.makeText(this, "A.I가 아닌 다른 이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    //Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
                    Intent intent2board = new Intent(this, ChessBoard.class);
                    intent2board.putExtra("P1NAME", player1_name);
                    intent2board.putExtra("P2NAME", player2_name);
                    startActivity(intent2board);
                    finish();
                    break;
                }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent inentmain = new Intent(this, MainActivity.class);
        startActivity(inentmain);
        finish();
    }
}
