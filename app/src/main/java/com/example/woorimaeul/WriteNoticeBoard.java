package com.example.woorimaeul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WriteNoticeBoard extends AppCompatActivity {

    Button complete; // Button 변수 선언

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writenotice_board); // 디자인 화면이랑 이 java파일이랑 연결하는 부분

        complete = findViewById(R.id.completeButton); // 디자인 화면의 버튼과 연결

        complete.setOnClickListener(new View.OnClickListener() { // 버튼이 클릭 됐을 때 어떤 작업을 할지 설정.
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), MainActivity.class); // 이동할 대상 화면 설정
                startActivity(intent); // 이동
            }
        });
    }
}
