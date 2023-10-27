package me.hostedby.aptivydroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView AptivyWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AptivyWebView=(WebView) findViewById(R.id.webview);
        AptivyWebView.setWebViewClient(new WebViewClient());
        AptivyWebView.loadUrl("https://www.rustige.me");
        WebSettings webSettings=AptivyWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public class AptivyWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        if (AptivyWebView.canGoBack()) {
            AptivyWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}