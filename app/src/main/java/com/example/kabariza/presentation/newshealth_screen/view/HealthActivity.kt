package com.example.kabariza.presentation.newshealth_screen.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kabariza.R
import com.example.kabariza.databinding.ActivityHealthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHealthBinding
    private lateinit var progressBar: ProgressBar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        webViewSetup(url)

        binding.backhealth.setOnClickListener{
            if(binding.wvhealth.canGoBack()){
                binding.wvhealth.goBack()
            }else{
                finish()
            }
        }
    }
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(baseurl:String?){
        binding.wvhealth.webViewClient= WebViewClient()
        progressBar=findViewById(R.id.pbhealth)
        binding.wvhealth.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
        baseurl?.let{
            binding.wvhealth.loadUrl(it)
        }
    }
}