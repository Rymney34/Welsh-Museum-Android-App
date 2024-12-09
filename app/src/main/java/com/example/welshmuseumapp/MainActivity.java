package com.example.welshmuseumapp;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RouteListingPreference;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {


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

        TextView appName = findViewById(R.id.appName);

        TextView cardiffM = findViewById(R.id.cardiffM);

        TextView stF = findViewById(R.id.stF);

        TextView rlM = findViewById(R.id.rlM);
//
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

                if(id == R.id.AccessFtr){
                    Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    startActivity(intent);

                }
                if(id == R.id.contentLib){
                    Intent intent = new Intent(MainActivity.this, ContentLibrary.class);
                    startActivity(intent);
                }

                if (id == R.id.close_btn) {
                    finish();
                    return true;
                }
                return false;
            }
        });

        MenuItem switchItem = myNavigationView.getMenu().findItem(R.id.app_bar_switch);
        Switch languageSwitch = (Switch) switchItem.getActionView().findViewById(R.id.switch_id);


        boolean isWelsh = LanguagePreference.getLanguage(this).equals("cy");
        languageSwitch.setChecked(isWelsh);


        languageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String newLanguage;


                if (isChecked) {
                    newLanguage = "cy";

                } else {
                    newLanguage = "en";
                }
                LanguagePreference.saveLanguage(MainActivity.this, newLanguage);

                recreate();
            }
        });

        appName.setText(resources.getString(R.string.welsh_heritage));
        cardiffM.setText(resources.getString(R.string.crdffMuseum));
        stF.setText(resources.getString(R.string.stFagans));
        rlM.setText(resources.getString(R.string.rlm));



        menuBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(findViewById(R.id.navMn));



                TextView menuName = findViewById(R.id.menuName);


//                drawerLayout.closeDrawer(R.id.navMn);

            }
        });
        NavigationView navigationView = findViewById(R.id.navMn);
        Menu menu = navigationView.getMenu();

        menu.findItem(R.id.contentLib).setTitle(resources.getString(R.string.content_library));
        menu.findItem(R.id.eventsNe).setTitle(resources.getString(R.string.events_and_news));
        menu.findItem(R.id.AccessFtr).setTitle(resources.getString(R.string.accessability_settings));
        menu.findItem(R.id.app_bar_switch).setTitle(resources.getString(R.string.change_english_to_welsh));
        menu.findItem(R.id.close_btn).setTitle(resources.getString(R.string.close));


        View headerView = navigationView.getHeaderView(0);
        TextView menuNameHeader = headerView.findViewById(R.id.menuName);
        menuNameHeader.setText(resources.getString(R.string.menu));

//        drawerLayout.openDrawer(findViewById(R.id.navMn));

        museumBtn1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startNewActivity(v,Museum.class);

            }
        });

        museumBtn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

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

    public void startNewActivity3(Class<?> museum){
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