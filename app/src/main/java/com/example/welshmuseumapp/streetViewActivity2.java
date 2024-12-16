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

public class streetViewActivity2 extends BaseActivity {

    private static final LatLng stFagans1 = new LatLng(51.486501, -3.273409);

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
                            panorama.setPosition(stFagans1);
                        }
                    }
                });

    }



//    public void startNewActivity(View v){
//        Intent intent = new Intent(this, Museum.class);
//        startActivity(intent);
//    }

}
