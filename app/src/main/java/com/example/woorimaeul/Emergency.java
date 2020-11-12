package com.example.woorimaeul;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Emergency extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borad_emergency);   // 일단 화면만 표시

        final ImageButton bt_set = (ImageButton)findViewById(R.id.emrge_to_setting);  //설정 이미지 버튼
        //final ImageButton bt_home = (ImageButton)findViewById(R.id.to_home);  //이미지 버튼이 아닌 이미지뷰라서 버튼으로 설정 해야함


        bt_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), SettingMain.class);
                startActivity(intent);
            }
        });

       /* bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
}