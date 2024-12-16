package com.example.welshmuseumapp;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DegreeTour3 extends BaseActivity {

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


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView1.getSettings().setAllowFileAccessFromFileURLs(true);
        webView1.loadUrl("https://my.matterport.com/show/?m=ihBWMNFMBA3");

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView2.getSettings().setAllowFileAccessFromFileURLs(true);
        webView2.loadUrl("https://my.matterport.com/show/?m=Xgf7RFTHndg");

        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView3.getSettings().setAllowFileAccessFromFileURLs(true);
        webView3.loadUrl("https://my.matterport.com/show/?m=FNW7ab3eFdV");



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

