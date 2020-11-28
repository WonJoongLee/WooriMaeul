package com.example.woorimaeul.upload;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.woorimaeul.BoardList;
import com.example.woorimaeul.MainActivity;
import com.example.woorimaeul.R;
import com.example.woorimaeul.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WriteNoticeBoard extends AppCompatActivity {

    ImageButton complete; // Button 변수 선언
    private FirebaseDatabase database;
    private DatabaseReference databaseReference, databaseReferenceUser;
    private EditText uTitle, uArticle;
    Board board;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String userId, name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writenotice_board);

        complete = findViewById(R.id.completeButton);
        uTitle = (EditText) findViewById(R.id.uploadTitle);//글 제목
        uArticle = (EditText) findViewById(R.id.uploadArticle);//글 내용

        database = FirebaseDatabase.getInstance();//db위치로부터 값 가져옴
        databaseReference = database.getReference("Posting").child("Free");
        databaseReferenceUser = database.getReference("Users");

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userId = firebaseUser.getUid();//userId에 user 키 값 저장

        databaseReferenceUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("@@@@got in");
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    User user = snapshot1.getValue(User.class);
                    if(user.getUid().equals(userId)){
                        System.out.println("@@@@hello Found it!");
                        name = user.getName();
                        System.out.println("@@@@@name is "+name);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        complete.setOnClickListener(new View.OnClickListener() { // 버튼 클릭 되면 서버로 전송하고 메인 액티비티로 복귀
            @Override
            public void onClick(View view) {
                System.out.println("@@@여기까지들어와짐");

                board = new Board(uTitle.getText().toString(), uArticle.getText().toString(), name);
                databaseReference.push().setValue(board);

                Intent intent =new Intent(getApplicationContext(), MainActivity.class); // 이동할 대상 화면 설정
                startActivity(intent); // 이동
            }
        });
    }
}
