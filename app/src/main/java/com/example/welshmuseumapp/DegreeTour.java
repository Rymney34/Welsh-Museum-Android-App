package com.example.welshmuseumapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DegreeTour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.degree_tour);

        WebView webView1 = findViewById(R.id.webView1);

        ImageView btnBack = findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView1.getSettings().setAllowFileAccessFromFileURLs(true);
        webView1.loadUrl("https://my.matterport.com/show/?m=VLWSNX62ax8");

//        webView1.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if(url.contains("matterport.com/vr/show")) {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//                    return true;
//                }
//                return false;
//            }
//        });
    }
}
