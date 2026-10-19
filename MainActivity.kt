package com.warehouse.billing

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.JavascriptInterface
import android.content.Context
import android.print.PrintAttributes
import android.print.PrintManager
import android.content.Context.PRINT_SERVICE

class MainActivity : Activity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(this)
        setContentView(webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = true
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()
        webView.addJavascriptInterface(PrintBridge(this, webView), "AndroidPrint")
        webView.loadUrl("file:///android_asset/index.html")
    }
    @Deprecated("Deprecated in Android API")
    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}

class PrintBridge(private val context: Context, private val webView: WebView) {
    @JavascriptInterface
    fun printPage() {
        val manager = context.getSystemService(PRINT_SERVICE) as PrintManager
        val adapter = webView.createPrintDocumentAdapter("WarehouseBill")
        manager.print("Warehouse Bill", adapter, PrintAttributes.Builder().build())
    }
}
