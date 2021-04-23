package com.tr.newsappcent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class favwebActivity extends AppCompatActivity {

    private WebView webview;
    private TextView baslikk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favweb);

        webview = findViewById(R.id.webview);
        baslikk=findViewById(R.id.baslikk);

        Intent intentt = getIntent();
        String webb = intentt.getExtras().getString("Link");


        webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl(webb);
    }
}