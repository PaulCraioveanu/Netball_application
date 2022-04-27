package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import android.os.Bundle;

public class IntermediateDrillActivity extends AppCompatActivity {

    WebView webView, webView2;
    String videoID, videoID2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_drill);

        videoID = "Rr47iZT9rgg";
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.loadUrl("https://www.youtube.com/embed/" + videoID + "?autoplay=1&vq=small");
        webView.setWebChromeClient(new WebChromeClient());

        videoID2 = "SO0Vr_6KuQI";
        webView2 = findViewById(R.id.webView2);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView2.loadUrl("https://www.youtube.com/embed/" + videoID2 + "?autoplay=1&vq=small");
        webView2.setWebChromeClient(new WebChromeClient());
    }
}