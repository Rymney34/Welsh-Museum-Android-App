package com.example.welshmuseumapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Museum extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.museum1);

        Window window = getWindow();


        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));

        RelativeLayout relativeLayout2 = findViewById(R.id.relativeLayout2);

        ImageView facebookBtn = findViewById(R.id.facebookBtn);

        ImageView instBtn = findViewById(R.id.instagramBtn);

        ImageView btnBack = findViewById(R.id.btnBack);

        relativeLayout2.bringToFront();

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        WebView webView = findViewById(R.id.webView);

        CardView imersiveExp = findViewById(R.id.imersiveExp);

        TextView textView4 = findViewById(R.id.textView4);


        TextView textViewName = findViewById(R.id.textViewName);
        TextView textView2 = findViewById(R.id.textView2);

        TextView textView8 = findViewById(R.id.textView8);

        TextView textView3 = findViewById(R.id.textView3);

        TextView textView7 = findViewById(R.id.textView7);

        TextView textView9 = findViewById(R.id.textView9);

        TextView textView6 = findViewById(R.id.textView6);

        TextView textView10 = findViewById(R.id.textView10);

        TextView textView11 =findViewById(R.id.textView11);

        textView7.setText(resources.getString(R.string.cardiffexhibitsSlider));
        textView9.setText(resources.getString(R.string.cardiffexhibitsdesc));


        textView11.setText(resources.getString(R.string.leave_review));

        textView4.setText(resources.getString(R.string.welsh_heritage));

        textViewName.setText(resources.getString(R.string.national_museum_cardiff));

        textView2.setText(resources.getString(R.string.exhibits_highlights));

        textView8.setText(resources.getString(R.string.exhibits_highlights_video));

        textView3.setText(resources.getString(R.string.immersive_experience));

        textView6.setText(resources.getString(R.string.google_street_viewTxt));

        textView10.setText(resources.getString(R.string._360_degree_tour));


        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Q3bt-id9P2s?si=w1vHsNguSuQr9tAM\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html","utf-8");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        ArrayList<SlideModel> slideModels = new ArrayList<>();


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        slideModels.add(new SlideModel(R.drawable.dinocrdf, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.vase_crdf, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.fossil_print, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.iron_meteor, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

//       Copyright [2024] denzcoskun

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imersiveExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v);
            }
        });

        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/museumcardiff/?locale=en_GB"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/appetizerandroid")));
                }
            }
        });



        instBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cardiffnationalmuseum/"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/appetizerandroid")));
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.musseum1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void startNewActivity(View v){
        Intent intent = new Intent(this, ImmersiveExp.class);
        startActivity(intent);
    }



}
