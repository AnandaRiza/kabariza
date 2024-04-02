package com.example.kabariza.presentation.newstech_screen.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kabariza.R
import com.example.kabariza.databinding.ActivityTechBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTechBinding
    private lateinit var progressBar: ProgressBar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        webViewSetup(url)

        binding.backtech .setOnClickListener{
            if(binding.wvtech.canGoBack()){
                binding.wvtech .goBack()
            }else{
                finish()
            }
        }

    }
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(baseurl:String?)
    {
        binding.wvtech.webViewClient= WebViewClient()
        progressBar=findViewById(R.id.pbtech)
        binding.wvtech.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
        baseurl?.let{
            binding.wvtech.loadUrl(it)
        }

    }


}