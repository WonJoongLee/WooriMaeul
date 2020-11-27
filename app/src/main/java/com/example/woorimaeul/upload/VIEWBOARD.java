package com.example.woorimaeul.upload;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.woorimaeul.MainActivity;
import com.example.woorimaeul.R;

public class VIEWBOARD extends AppCompatActivity {

    ImageButton send_b;
    private EditText uTitle, uArticle;
    Board board;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_board);

        send_b = findViewById(R.id.send);

        send_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //board = new Board(uTitle.getText().toString(), uArticle.getText().toString());

                Intent intent =new Intent(getApplicationContext(), MainActivity.class); // 이동할 대상 화면 설정
                startActivity(intent); // 이동
            }
        });
    }
}
