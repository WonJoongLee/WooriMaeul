package com.example.woorimaeul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.woorimaeul.upload.WriteNoticeBoard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    LinearLayout button_emergency, button_free, button_ad, button_information;
    ImageButton MainToSetting, button_viewboard;
    FirebaseUser fbUser;


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
        button_viewboard=findViewById(R.id.send);

        fbUser = FirebaseAuth.getInstance().getCurrentUser();
        if(fbUser==null){
            System.out.println("@@@user is null");
        }else{
            System.out.println("@@@user got in");
        }

        button_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), board.class);
                intent.putExtra("boardName", "긴급게시판");
                intent.putExtra("dbBoard", "Emergency");
                startActivity(intent);
            }
        });

        button_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), board.class);
                intent.putExtra("boardName", "자유게시판");
                intent.putExtra("dbBoard", "Free");
                startActivity(intent);
            }
        });

        /*
        button_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), WriteNoticeBoard.class);
                startActivity(intent);
            }
        });*/

        /*
        button_viewboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), WriteNoticeBoard.class);
                startActivity(intent);
            }
        });*/

        button_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), board.class);
                intent.putExtra("boardName", "홍보게시판");
                intent.putExtra("dbBoard", "Ad");
                startActivity(intent);
            }
        });

        button_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), board.class);
                intent.putExtra("boardName", "정보게시판");
                intent.putExtra("dbBoard", "Info");
                startActivity(intent);
            }
        });

        MainToSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fbUser==null){
                    Intent intent =new Intent(getApplicationContext(), SettingMain.class);
                    startActivity(intent);
                }else{
                    Intent intent =new Intent(getApplicationContext(), ShowLogin.class);
                    startActivity(intent);
                }

            }
        });
    }
}