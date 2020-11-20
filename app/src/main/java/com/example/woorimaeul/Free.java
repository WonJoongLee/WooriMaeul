package com.example.woorimaeul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Free extends AppCompatActivity {

    Button write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_free);       //일단 화면만 표시


        final ImageButton bt_set = (ImageButton)findViewById(R.id.free_to_setting);  //설정 이미지 버튼
        write = findViewById(R.id.write_button);

        bt_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), SettingMain.class);
                startActivity(intent);
            }
        });

        setContentView(R.layout.writenotice_board);


        write.setOnClickListener(new View.OnClickListener() { // 버튼이 클릭 됐을 때 어떤 작업을 할지 설정.
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), WriteNoticeBoard.class); // 이동할 대상 화면 설정
                startActivity(intent); // 이동
            }
        });

    }
}