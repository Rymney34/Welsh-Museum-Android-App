package com.example.welshmuseumapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;

public class AccessabilitySettings extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.accessibility_set);


        TextView accessSet = findViewById(R.id.accessSetV);

        ImageView btnBack = findViewById(R.id.btnBack);


        Button talkBackBtn = findViewById(R.id.TalkBackBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        talkBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
            }
        });


    }
}
