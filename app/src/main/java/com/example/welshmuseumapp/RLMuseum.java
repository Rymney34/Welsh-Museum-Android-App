package com.example.welshmuseumapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class RLMuseum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.museum1);




        TextView textViewName, textView7, textView9;

        ImageView museumImg, btnBack;



        RelativeLayout relativeLayout2 = findViewById(R.id.relativeLayout2);

        relativeLayout2.bringToFront();

        textViewName = findViewById(R.id.textViewName);


        textView7 = findViewById(R.id.textView7);

        textView9 = findViewById(R.id.textView9);

        museumImg = findViewById(R.id.museumImg);

        btnBack = findViewById(R.id.btnBack);

        WebView webView = findViewById(R.id.webView);

        CardView imersiveExp = findViewById(R.id.imersiveExp);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnBack(v);
            }
        });

        textViewName.setText("National Roman Legion Museum");


        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        textViewName.setLayoutParams(params1);

        params1.setMargins(dpToPx(60), dpToPx(12), 0, 0);

        museumImg.setImageResource(R.drawable.rlm);


        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) museumImg.getLayoutParams();

        params.width = dpToPx(870);

        params.height = dpToPx(630);

        params.setMargins(0, dpToPx(8), dpToPx(0), 0);

        museumImg.setLayoutParams(params);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<SlideModel>();


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        slideModels.add(new SlideModel(R.drawable.rlm1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.rlm2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.rlm6, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.rlmbath, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gljN1HN-ASc?si=QiynvXurOCpqRelf\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html","utf-8");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        imersiveExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.musseum1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void startNewActivity(View v){
        Intent intent = new Intent(this, ImmersiveExp3.class);
        startActivity(intent);
    }

    int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
    public void returnBack (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
