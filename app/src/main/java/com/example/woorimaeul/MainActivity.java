package com.example.woorimaeul;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout button_emergency, button_free, button_ad, button_information;
    ImageButton MainToSetting;


    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_emergency = findViewById(R.id.board_emergency);
        button_free = findViewById(R.id.board_free);
        button_ad = findViewById(R.id.board_ad);
        button_information = findViewById(R.id.board_info);
        MainToSetting = findViewById(R.id.main_to_setting);

        button_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), board.class); 
                startActivity(intent);
            }
        });

        button_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Free.class);
                startActivity(intent);
            }
        });

        button_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Advertise.class);
                startActivity(intent);
            }
        });

        button_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Information.class);
                startActivity(intent);
            }
        });

        MainToSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), SettingMain.class);
                //Intent intent =new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });


        //TODO bottom navigation fragments 세팅
    }


}