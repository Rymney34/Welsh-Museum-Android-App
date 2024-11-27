package com.example.welshmuseumapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImmersiveExp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.imersive_exp);

        ImageView btnBack = findViewById(R.id.btnBack);

        CardView btn1 = findViewById(R.id.btn1);

        CardView btn2 = findViewById(R.id.btn2);

        CardView btn3 = findViewById(R.id.btn3);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity2(v);
            }
        });


    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imerExp), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });
    }

    public void startNewActivity(View v){
        Intent intent = new Intent(this, Museum.class);
        startActivity(intent);
    }

    public void startNewActivity2(View v){
        Intent intent = new Intent(this, StreetViewActivity.class);
        startActivity(intent);
    }
}
