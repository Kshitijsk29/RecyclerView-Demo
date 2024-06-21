package com.nextin.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nextin.recyclerviewdemo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    val binding : ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val heading = intent.getStringExtra("newsTitle")
        val contentH = intent.getStringExtra("content")
        val image = intent.getIntExtra("newsImage",R.drawable.news_img1)

        binding.tvHeading.text = heading
        binding.description.text = contentH
        binding.imageView.setImageResource(image)
    }
}