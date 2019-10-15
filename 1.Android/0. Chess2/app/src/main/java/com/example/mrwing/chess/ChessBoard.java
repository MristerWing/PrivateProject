package com.example.mrwing.chess;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

public class ChessBoard extends Activity {
    private  static Context mContext;
    private static TextView playerTurn;
    private static FrameLayout boardLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_board);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);

        TextView p1 = findViewById(R.id.p1NAME);
        TextView p2 = findViewById(R.id.p2NAME);
        boardLayout = findViewById(R.id.board_layout);
        DisplayMetrics m_DisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m_DisplayMetrics);

        Intent intent = getIntent();
        String p1_name = intent.getExtras().getString("P1NAME");
        String p2_name = intent.getExtras().getString("P2NAME");

        playerTurn = findViewById(R.id.player_turn);
        ChessView chessBoard = new ChessView(this, m_DisplayMetrics.widthPixels, p1_name, p2_name);
        chessBoard.setLayoutParams(new FrameLayout.LayoutParams(m_DisplayMetrics.widthPixels, m_DisplayMetrics.widthPixels));

        boardLayout.addView(chessBoard);

        p1.setText("P1: " + p1_name);
        p2.setText("P2: " + p2_name);

    }

    public static void setPlayerTurn(String plT) {
        playerTurn.setText(plT);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public static void gameOver() {
        if(mContext != null){
            ((ChessBoard)mContext).finish();
            ((FrameLayout)boardLayout).removeAllViews();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }

}
