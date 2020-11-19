package com.example.woorimaeul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Notify extends AppCompatActivity {

    LinearLayout button_comment, button_emrgency_notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);

        button_comment = findViewById(R.id.comment_notice);
        button_emrgency_notify = findViewById(R.id.emergency_notice);

        button_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Comment.class);
                startActivity(intent);
            }
        });
        button_emrgency_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Emergency_notify.class);
                startActivity(intent);
            }
        });
    }
}