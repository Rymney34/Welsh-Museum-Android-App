package com.example.welshmuseumapp;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class StreetViewActivity3 extends BaseActivity {

    private static final LatLng RlmStrView = new LatLng(51.610020, -2.95544);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.street_view);

        Window window = getWindow();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));

        ImageView btnBack1 = findViewById(R.id.btnBack);

        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {

                        if (savedInstanceState == null) {
                            panorama.setPosition(RlmStrView);
                        }
                    }
                });

    }



//    public void startNewActivity(View v){
//        Intent intent = new Intent(this, Museum.class);
//        startActivity(intent);
//    }

}
