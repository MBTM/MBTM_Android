package com.example.mbtm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.mbtm.databinding.ActivityTestBinding


class TestActivity : AppCompatActivity() {

    lateinit var binding: ActivityTestBinding
    lateinit var webView: WebView
    lateinit var mbti: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initWebView()

        binding.testSaveBtn.setOnClickListener {
            saveMbti()

            val intent = Intent()
            intent.putExtra("mbti", mbti)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.testCloseIc.setOnClickListener {
            finish()
        }
    }

    private fun saveMbti() {
        var url: String = webView.url.toString()
        mbti = url.substring(url.length - 4).uppercase()
        binding.testSaveBtn.text = mbti
        Log.d("OKOK/TEST/", mbti)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {

        Log.d("OKOK/TEST/", "initWebView1")

        val intent = intent
        val bundle = intent.extras
        val testValue = bundle!!.getString("Url")

        webView = findViewById<WebView>(R.id.test_wv)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportMultipleWindows(true)
        }

        webView.webViewClient = WebViewClient()
        webView.loadUrl(testValue!!)
        Log.d("OKOK/TEST/", "initWebView2")
    }


}