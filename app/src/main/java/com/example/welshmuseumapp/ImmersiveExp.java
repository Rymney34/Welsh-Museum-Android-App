package com.example.welshmuseumapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImmersiveExp extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.imersive_exp);

        ImageView btnBack = findViewById(R.id.btnBack);

        CardView btn1 = findViewById(R.id.btn1);

        CardView btn2 = findViewById(R.id.btn2);

        CardView btn3 = findViewById(R.id.btn3);

        TextView panoramic2 = findViewById(R.id.panoramic2);

        TextView panoramic = findViewById(R.id.panoramic);

        TextView degreeTour = findViewById(R.id.deegree_tour);

        TextView textView5 = findViewById(R.id.textView5);

        textView5.setText(resources.getString(R.string.immersive_experience));

        panoramic2.setText(resources.getString(R.string.panoramic_image));
        panoramic.setText(resources.getString(R.string.google_street_viewTxt));
        degreeTour.setText(resources.getString(R.string._360_degree_tour));


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v, StreetViewActivity.class);
            }
        });

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startNewActivity2(v);
//            }
//        });


    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imerExp), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });
    }

//    public void startNewActivity(View v){
//        Intent intent = new Intent(this, Museum.class);
//        startActivity(intent);
//    }

    public void startNewActivity(View v, Class<?> museum){
        Intent intent = new Intent(this, museum);
        startActivity(intent);
    }
}
