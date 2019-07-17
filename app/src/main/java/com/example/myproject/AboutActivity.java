package com.example.myproject;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        final WebView webView = findViewById(R.id.web_page);
//        final ProgressBar progressBar = findViewById(R.id.progressBar);

        WebSettings webset = webView.getSettings();
        webset.setJavaScriptEnabled(true);
        webset.setBuiltInZoomControls(true);
        webset.setAllowContentAccess(true);
        webset.setUseWideViewPort(true);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, "https://andela.com/alc/");
                return false;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
//                progressBar.setVisibility(webView.vis);
                handler.proceed();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }
        });
       webView.loadUrl("https://andela.com/alc/");
//        webView.loadUrl("https://google.com");

    }

}
