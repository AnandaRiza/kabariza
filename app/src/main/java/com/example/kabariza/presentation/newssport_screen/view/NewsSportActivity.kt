package com.example.kabariza.presentation.newssport_screen.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kabariza.R
import com.example.kabariza.databinding.ActivitySportBinding

class NewsSportActivity  : AppCompatActivity() {
    private lateinit var binding: ActivitySportBinding
//    private lateinit var progressBar: ProgressBar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        webViewSetup(url)

        binding.backsport.setOnClickListener{
            if(binding.wvsport.canGoBack()){
                binding.wvsport.goBack()
            }else{
                finish()
            }
        }
    }
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(baseurl:String?){
        binding.wvsport.webViewClient= WebViewClient()
//        progressBar=findViewById(R.id.pbsport)
        binding.wvsport.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
        baseurl?.let{
            binding.wvsport.loadUrl(it)
        }
    }

}