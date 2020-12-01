package com.example.woorimaeul;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woorimaeul.upload.WriteNoticeBoard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class board extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<BoardList> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private Intent intent;
    private String boardName, dbBoard;
    private TextView boardNameTextview;
    private Button writeButton;
    private FirebaseUser fbUser;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        recyclerView = findViewById(R.id.BoardRecyclerView);  // 아이디 연결
        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // BoardList 객체를 담을 어레이 리스트(어뎁터 쪽으로)

        database  = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동

        fbUser = FirebaseAuth.getInstance().getCurrentUser();

        intent = getIntent();//MainActivity에서 사용자가 어떤 게시판을 클릭했는지 추적
        boardName = intent.getStringExtra("boardName");//예를 들면, Mainactivity에서 긴급게시판을 클릭했으면 boardName String에 boardName 저장
        dbBoard = intent.getStringExtra("dbBoard");//서버에서 어떤 게시판을 불러올 지 설정하기 위해 dbBoard에 String저장
        boardNameTextview = findViewById(R.id.board_name);
        boardNameTextview.setText(boardName);//MainActivity에서 어떤 값을 클릭했느냐에 따라 게시판 이름 설정
        writeButton = findViewById(R.id.button_write);

        if(boardName.equals("긴급게시판")){//긴급게시판이면 사용자가 글을 작성할 수 없도록 글쓰기 버튼 비활성화
            writeButton.setVisibility(View.GONE);
        }

        databaseReference = database.getReference().child("Posting").child(dbBoard); //DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();  //기존 배열 리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : datasnapshot.getChildren()){   //반복문으로 데이터 list 추출
                    BoardList boardList = snapshot.getValue(BoardList.class);   //만들어둔 BoardList 객체에 데이터를 담는다
                    arrayList.add(boardList);   //담은 데이터를 배열리스트에 넣고 리사이클러로 보낼준비
                }
                System.out.println("@@@@"+arrayList.size());
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로 고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //디비를 가져오던 중 에러 발생 시
                Log.e("board", String.valueOf(error.toException())); //에러문 출력
            }
        });

        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어뎁터 연결


        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fbUser!=null) {
                    Intent intent = new Intent(getApplicationContext(), WriteNoticeBoard.class);
                    intent.putExtra("dbBoard", dbBoard);
                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "먼저 로그인을 해주세요!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
