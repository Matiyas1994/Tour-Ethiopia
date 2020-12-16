package com.example.tourethiopia;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myview= inflater.inflate(R.layout.fragment_map, container, false);

        final ProgressBar progressBar=myview.findViewById(R.id.progressbar);
        WebView mapwebview= myview.findViewById(R.id.mapview);
        WebSettings webSettings =mapwebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
mapwebview.setWebViewClient(new WebViewClient(){

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
progressBar.setVisibility(view.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        progressBar.setVisibility(view.GONE);
    }
});

        mapwebview.loadUrl("https://www.google.com/maps");

        return myview;

    }
}