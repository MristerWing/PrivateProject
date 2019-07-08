package com.example.mrwing.chess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mDatas = new ArrayList<String>();

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_main);

        mDatas.add("A.I Vs A.I Simulation");
        mDatas.add("A.I Vs Human");
        mDatas.add("Human Vs Human");
        mDatas.add("Developer Info");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mDatas);
        final Intent intent = getIntent();

        listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            //ListView의 아이템 중 하나가 클릭될 때 호출되는 메소드
            //첫번째 파라미터 : 클릭된 아이템을 보여주고 있는 AdapterView 객체(여기서는 ListView객체)
            //두번째 파라미터 : 클릭된 아이템 뷰
            //세번째 파라미터 : 클릭된 아이템의 위치(ListView이 첫번째 아이템(가장위쪽)부터 차례대로 0,1,2,3.....)
            //네번재 파리미터 : 클릭된 아이템의 아이디(특별한 설정이 없다면 세번째 파라이터인 position과 같은 값)

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                switch (position) {
                    case 0:
                        Intent intent1set = new Intent(getApplicationContext(), NameInput.class);
                        intent1set.putExtra("P1AI", "AI");
                        intent1set.putExtra("P2AI", "AI");
                        startActivity(intent1set);
                        finish();
                        break;
                    case 1:
                        Intent intent2set = new Intent(getApplicationContext(), NameInput.class);
                        intent2set.putExtra("P1AI", "null");
                        intent2set.putExtra("P2AI", "AI");
                        startActivity(intent2set);
                        finish();
                        break;
                    case 2:
                        Intent intent3set = new Intent(getApplicationContext(), NameInput.class);
                        intent3set.putExtra("P1AI", "null");
                        intent3set.putExtra("P2AI", "null");
                        startActivity(intent3set);
                        finish();
                        break;
                    case 3:
                        break;
                }
            }
        });
    }

}

