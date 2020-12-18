package com.example.tourethiopia

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MapFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myview = inflater.inflate(R.layout.fragment_map, container, false)
        val progressBar = myview.findViewById<ProgressBar>(R.id.progressbar)
        val mapwebview = myview.findViewById<WebView>(R.id.mapview)
        val webSettings = mapwebview.settings
        webSettings.javaScriptEnabled = true
        mapwebview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        }
        mapwebview.loadUrl("https://www.google.com/maps")
        return myview
    }
}