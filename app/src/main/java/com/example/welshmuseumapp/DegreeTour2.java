package com.example.welshmuseumapp;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DegreeTour2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.degree_tour);

        Window window = getWindow();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));

        WebView webView1 = findViewById(R.id.webView1);

        WebView webView2 = findViewById(R.id.webView2);

        WebView webView3 = findViewById(R.id.webView3);

        WebView webView4 = findViewById(R.id.webView4);

        ImageView btnBack = findViewById(R.id.btnBack);

        TextView txtView13 = findViewById(R.id.textView13);

        txtView13.setText(resources.getString(R.string._360_degree_tour));


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView1.getSettings().setAllowFileAccessFromFileURLs(true);
        webView1.loadUrl("https://my.matterport.com/show/?m=YuDBAPutXF3");

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView2.getSettings().setAllowFileAccessFromFileURLs(true);
        webView2.loadUrl("https://my.matterport.com/show/?m=t96nWAzMojA");

        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView3.getSettings().setAllowFileAccessFromFileURLs(true);
        webView3.loadUrl("https://my.matterport.com/show/?m=K7owj31R28B");

        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView4.getSettings().setAllowFileAccessFromFileURLs(true);
        webView4.loadUrl("https://my.matterport.com/show/?m=V9x5FLYojwr");



//        });
    }
}

