package com.example.woorimaeul.upload;

import android.content.Intent;
import android.media.Image;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteNoticeBoard extends AppCompatActivity {

    ImageButton complete; // Button 변수 선언
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private EditText uTitle, uArticle;
    Board board;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writenotice_board);

        complete = findViewById(R.id.completeButton);
        uTitle = (EditText) findViewById(R.id.uploadTitle);//글 제목
        uArticle = (EditText) findViewById(R.id.uploadArticle);//글 내용

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Posting").child("Free");

        complete.setOnClickListener(new View.OnClickListener() { // 버튼 클릭 되면 서버로 전송하고 메인 액티비티로 복귀
            @Override
            public void onClick(View view) {
                System.out.println("@@@여기까지들어와짐");

                board = new Board(uTitle.getText().toString(), uArticle.getText().toString());
                databaseReference.push().setValue(board);

                Intent intent =new Intent(getApplicationContext(), MainActivity.class); // 이동할 대상 화면 설정
                startActivity(intent); // 이동
            }
        });
    }
}
