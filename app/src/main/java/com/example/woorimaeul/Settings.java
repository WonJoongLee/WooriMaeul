package com.example.woorimaeul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Settings extends AppCompatActivity {

    LinearLayout button_notify, button_inform, button_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        button_notify = findViewById(R.id.settings_notice);
        button_inform = findViewById(R.id.setting_identification);
        button_theme = findViewById(R.id.settings_theme);

        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);
            }
        });
        button_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);
            }
        });

        button_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Theme.class);
                startActivity(intent);
            }
        });
    }
}