
package com.example.welshmuseumapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImmersiveExp3 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.imersive_exp);


        Window window = getWindow();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));

        CardView btn2 = findViewById(R.id.btn2);

        CardView btn3 = findViewById(R.id.btn3);

        ImageView btnBack = findViewById(R.id.btnBack);



        TextView panoramic = findViewById(R.id.panoramic);

        TextView degreeTour = findViewById(R.id.deegree_tour);

        TextView textView5 = findViewById(R.id.textView5);

        textView5.setText(resources.getString(R.string.immersive_experience));


        panoramic.setText(resources.getString(R.string.google_street_viewTxt));
        degreeTour.setText(resources.getString(R.string._360_degree_tour));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v, StreetViewActivity3.class);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v, DegreeTour3.class);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imerExp), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void startNewActivity(View v, Class<?> museum){
        Intent intent = new Intent(this, museum);
        startActivity(intent);
    }


}
