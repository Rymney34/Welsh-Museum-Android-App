package com.example.welshmuseumapp;

import android.Manifest;
import android.annotation.SuppressLint;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.RouteListingPreference;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.provider.Settings;
import android.util.Log;
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
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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
    private Handler slider_handler;
    ViewPager VIEW_Pager;
    List<SlideItem> slideItems = new ArrayList<>();

    public static int REQUEST_CODE_NOTIFICATION_PERMISSION = 1;
    public static String CHANNEL_ID = "default_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Window window = getWindow();


        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));



        ImageView menuBtn;

        menuBtn = findViewById(R.id.menuBtn);

        TextView appName = findViewById(R.id.appName);

        TextView cardiffM = findViewById(R.id.cardiffM);

        TextView stF = findViewById(R.id.stF);

        TextView rlM = findViewById(R.id.rlM);

        ConstraintLayout museumBtn1 = findViewById(R.id.museumBtn1);

        ConstraintLayout museumBtn2 = findViewById(R.id.museumBtn2);

        ConstraintLayout museumBtn3 = findViewById(R.id.museumBtn3);

        RelativeLayout relativeLayout2 = findViewById(R.id.relativeLayout2);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView myNavigationView = findViewById(R.id.navMn);

        VIEW_Pager = findViewById(R.id.imgSlider);

        slider_handler= new Handler(Looper.getMainLooper());


        relativeLayout2.bringToFront();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, REQUEST_CODE_NOTIFICATION_PERMISSION);
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "D channel";
            String description = "D notification channel";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }



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
                    Intent intent = new Intent(MainActivity.this, ContentLibrary2.class);
                    startActivity(intent);
                }
                if(id == R.id.eventsNe){
                    Intent intent = new Intent(MainActivity.this, EventNews.class);
                    startActivity(intent);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {

                        Intent intent1 = new Intent(MainActivity.this, EventNews.class);

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent1, PendingIntent.FLAG_IMMUTABLE);

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)

                                .setSmallIcon(R.drawable.baseline_event_24)
                                .setContentTitle(resources.getString(R.string.not_Name))
                                .setContentText(resources.getString(R.string.not_Desc))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setContentIntent(pendingIntent)
                                .setAutoCancel(true);

                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                        notificationManager.notify(1, builder.build());


                    } else {

                        Toast.makeText(MainActivity.this, "Permission not granted ", Toast.LENGTH_SHORT).show();
                    }

                }

                if (id == R.id.close_btn) {
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });

        MenuItem switchItem = myNavigationView.getMenu().findItem(R.id.app_bar_switch);
        Switch languageSwitch = (Switch) switchItem.getActionView().findViewById(R.id.switch_id);

        TextView engch = switchItem.getActionView().findViewById(R.id.lang_english);

        TextView lang_welsh = switchItem.getActionView().findViewById(R.id.lang_welsh);

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

            }
        });
        NavigationView navigationView = findViewById(R.id.navMn);
        Menu menu = navigationView.getMenu();



        engch.setText(resources.getString(R.string.change_english));
        lang_welsh.setText(resources.getString(R.string.welsh));

        menu.findItem(R.id.contentLib).setTitle(resources.getString(R.string.content_library));
        menu.findItem(R.id.eventsNe).setTitle(resources.getString(R.string.events_and_news));
        menu.findItem(R.id.AccessFtr).setTitle(resources.getString(R.string.accessability_settings));
        menu.findItem(R.id.close_btn).setTitle(resources.getString(R.string.close));



        View headerView = navigationView.getHeaderView(0);
        TextView menuNameHeader = headerView.findViewById(R.id.menuName);
        menuNameHeader.setText(resources.getString(R.string.menu));



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
                startNewActivity(v, RLMuseum.class);
            }
        });


        slideItems.add(new SlideItem(R.drawable.cardiffm));
        slideItems.add(new SlideItem(R.drawable.rlm4));
        slideItems.add(new SlideItem(R.drawable.stfagans));
        slideItems.add(new SlideItem(R.drawable.stfagans2));


        SliderAdapter adapter = new SliderAdapter(this, slideItems);
        VIEW_Pager.setAdapter(adapter);

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
            int nextPage= (VIEW_Pager.getCurrentItem() + 1) % slideItems.size();
            VIEW_Pager.setCurrentItem(nextPage, true);
            VIEW_Pager.postDelayed(this, SLIDE_INTERVAL);

        }
    };


    public void startAutoSlide(){
        VIEW_Pager.postDelayed(sliderRunnable, SLIDE_INTERVAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        slider_handler.removeCallbacks(sliderRunnable);
    }
    @Override
    protected void onResume() {
        super.onResume();
        startAutoSlide();
    }
}