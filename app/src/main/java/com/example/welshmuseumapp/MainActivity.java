package com.example.welshmuseumapp;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    private final int SLIDE_INTERVAL = 7000;
    private Handler sliderHandler;
    ViewPager viewPager;
    List<SlideItem> slideItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Window window = getWindow();

        // Set status bar color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.noC));

        // Set navigation bar color
//        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.green));


        Museum cardiffPage = new Museum();

        ImageView menuBtn;

        menuBtn = findViewById(R.id.menuBtn);


        ConstraintLayout museumBtn1 = findViewById(R.id.museumBtn1);

        ConstraintLayout museumBtn2 = findViewById(R.id.museumBtn2);

        ConstraintLayout museumBtn3 = findViewById(R.id.museumBtn3);

        RelativeLayout relativeLayout2 = findViewById(R.id.relativeLayout2);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView myNavigationView = findViewById(R.id.navMn);

        viewPager = findViewById(R.id.imgSlider);

        sliderHandler = new Handler(Looper.getMainLooper());

        relativeLayout2.bringToFront();

        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.close_btn) {
                    finish();
                    return true;
                }
                return false;
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(findViewById(R.id.navMn));
            }
        });

        museumBtn1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startNewActivity(v,Museum.class);

            }
        });

        museumBtn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Toast Message", Toast.LENGTH_SHORT).show();
                startNewActivity(v, stFagans.class);
            }
        });
        museumBtn3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Toast Message", Toast.LENGTH_SHORT).show();
                startNewActivity(v, RLMuseum.class);
            }
        });


        slideItems.add(new SlideItem(R.drawable.cardiffm));
        slideItems.add(new SlideItem(R.drawable.rlm4));
        slideItems.add(new SlideItem(R.drawable.stfagans));
        slideItems.add(new SlideItem(R.drawable.stfagans2));


        SliderAdapter adapter = new SliderAdapter(this, slideItems);
        viewPager.setAdapter(adapter);

        startAutoSlide();




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void startNewActivity(View v, Class<?> museum){
        Intent intent = new Intent(this, museum);
        startActivity(intent);
    }


    Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int nextPage= (viewPager.getCurrentItem() + 1) % slideItems.size();
            viewPager.setCurrentItem(nextPage, true);
            sliderHandler.postDelayed(this, SLIDE_INTERVAL);

        }
    };



    public void startAutoSlide(){
        sliderHandler.postDelayed(sliderRunnable, SLIDE_INTERVAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
    @Override
    protected void onResume() {
        super.onResume();
        startAutoSlide();
    }
}