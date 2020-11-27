package com.example.woorimaeul;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        //databaseReference = database.getReference("BoardList"); //DB 테이블 연결
        databaseReference = database.getReference().child("Posting").child("Free"); //DB 테이블 연결
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
    }
}
