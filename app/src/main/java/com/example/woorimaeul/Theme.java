package com.example.woorimaeul;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Theme extends AppCompatActivity {

    LinearLayout button_light, button_dark;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_theme);     //일단 화면만 표시

        final ImageButton bt_set = (ImageButton)findViewById(R.id.theme_to_setting);  //설정 이미지 버튼

        bt_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), SettingMain.class);
                startActivity(intent);
            }
        });

    }
}