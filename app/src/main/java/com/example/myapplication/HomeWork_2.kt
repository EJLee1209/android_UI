package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import java.lang.Exception

class HomeWork_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work2)
        val text_url = findViewById<EditText>(R.id.url)
        val webView = findViewById<WebView>(R.id.webView).apply{
            this.webViewClient = WebViewClient()
//            this.settings.javaScriptEnabled = true
        }

        try{
            webView.loadUrl(
                intent.data!!.toString()
            )
        }catch(exception: Exception){

        }

        // addTextChangedListener 사용법

        text_url.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("testt", "beforeTextChanged : " + s)

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("testt", "onTextChanged : " + s)
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("testt", "afterTextChanged : " + s)
            }
        })
        // addTextChangedListener 사용법 -> 람다식
        text_url.doBeforeTextChanged { text, start, count, after ->  }
        text_url.doOnTextChanged { text, start, before, count ->  }
        text_url.doAfterTextChanged { }

        val btn_open = findViewById<TextView>(R.id.btn_open)

        btn_open.setOnClickListener {
            var url = text_url.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val webView = findViewById<WebView>(R.id.webView)
        if(webView.canGoBack()){
            webView.goBack()
        }
        else{
            finish()
        }
    }
}